package br.com.sample.messaging

import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.SubscribableChannel

const val PAYMENT_INPUT_CHANNEL = "payment-input"
const val PAYMENT_OUTPUT_CHANNEL = "payment-output"

interface PaymentStream {

    @Input(PAYMENT_INPUT_CHANNEL)
    fun paymentInputChannel(): SubscribableChannel

    @Output(PAYMENT_OUTPUT_CHANNEL)
    fun paymentOutputChannel(): MessageChannel
}