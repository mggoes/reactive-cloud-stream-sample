package br.com.sample.controller

import br.com.sample.model.PaymentDocument
import br.com.sample.service.PaymentService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/payments")
class PaymentController(private val service: PaymentService) {

    @PostMapping
    fun create(@RequestBody payment: Mono<PaymentDocument>) = this.service.send(payment)

    @GetMapping
    fun retrieveAll() = this.service.retrieveAll()
}