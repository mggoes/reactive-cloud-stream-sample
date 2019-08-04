package br.com.sample

import br.com.sample.config.Properties
import br.com.sample.messaging.PaymentStream
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.data.mongodb.config.EnableMongoAuditing

@SpringBootApplication
@EnableMongoAuditing
@EnableBinding(PaymentStream::class)
@EnableConfigurationProperties(Properties::class)
class ReactiveCloudStreamSampleApplication

fun main(args: Array<String>) {
    runApplication<ReactiveCloudStreamSampleApplication>(*args)
}
