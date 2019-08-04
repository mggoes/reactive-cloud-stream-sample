package br.com.sample.config

import org.springframework.boot.context.properties.ConfigurationProperties
import kotlin.properties.Delegates.notNull

@ConfigurationProperties("reactive-cloud-stream-sample")
class Properties {

    var partnerBaseUrl: String by notNull()
}