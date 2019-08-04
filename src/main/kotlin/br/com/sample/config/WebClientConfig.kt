package br.com.sample.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient.create

@Configuration
class WebClientConfig(private val properties: Properties) {

    @Bean
    fun partnerClient() = create(this.properties.partnerBaseUrl)
}