package br.com.sample.service

import br.com.sample.messaging.PaymentStream
import br.com.sample.model.PaymentDocument
import br.com.sample.repository.PaymentRepository
import org.springframework.integration.support.MutableMessageBuilder.withPayload
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.BodyInserters.fromPublisher
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class PaymentService(
    private val client: WebClient,
    private val stream: PaymentStream,
    private val repository: PaymentRepository
) {

    fun save(payment: Mono<PaymentDocument>) = this.client.post()
        .uri("/payments")
        .body(fromPublisher(payment, PaymentDocument::class.java))
        .exchange()
        .log()
        .flatMap { it.bodyToMono(PaymentDocument::class.java) }
        .log()
        .flatMap { this.repository.save(it) }
        .log()

    fun send(payment: Mono<PaymentDocument>) =
        payment.doOnNext { this.stream.paymentOutputChannel().send(withPayload(it).build()) }.log()

    fun retrieveAll() = this.repository.findAll()
}