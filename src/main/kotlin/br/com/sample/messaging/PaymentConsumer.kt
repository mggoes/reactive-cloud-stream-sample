package br.com.sample.messaging

import br.com.sample.model.PaymentDocument
import br.com.sample.service.PaymentService
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono.just

@Component
class PaymentConsumer(private val service: PaymentService) {

    @StreamListener(PAYMENT_INPUT_CHANNEL)
    fun consume(payment: PaymentDocument) {
        this.service.save(just(payment)).subscribe()
    }
}