package br.com.sample.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@JsonInclude(NON_EMPTY)
@Document("payment")
data class PaymentDocument(
    @Id
    @field:JsonProperty(access = READ_ONLY)
    var id: String?,

    @field:NotNull
    var value: BigDecimal,

    @field:NotEmpty
    var accountId: String,

    var integrationCode: String?,

    @CreatedDate
    @field:JsonProperty(access = READ_ONLY)
    var creationDate: LocalDateTime?
)