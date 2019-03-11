package com.localbitcoins.pojo.dashboard

import com.fasterxml.jackson.annotation.*
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
    "exchange_rate_updated_at",
    "advertisement",
    "is_buying",
    "created_at",
    "reference_code",
    "contact_id",
    "seller",
    "currency",
    "amount",
    "is_selling",
    "escrowed_at",
    "amount_btc",
    "canceled_at",
    "buyer",
    "closed_at",
    "funded_at",
    "account_info",
    "fee_btc",
    "payment_completed_at",
    "released_at"
)
class ContactData {

    @JsonProperty("exchange_rate_updated_at")
    @get:JsonProperty("exchange_rate_updated_at")
    @set:JsonProperty("exchange_rate_updated_at")
    var exchangeRateUpdatedAt: String? = null
    @JsonProperty("advertisement")
    @get:JsonProperty("advertisement")
    @set:JsonProperty("advertisement")
    var advertisement: Advertisement? = null
    @JsonProperty("is_buying")
    @get:JsonProperty("is_buying")
    @set:JsonProperty("is_buying")
    var isBuying: Boolean? = null
    @JsonProperty("created_at")
    @get:JsonProperty("created_at")
    @set:JsonProperty("created_at")
    var createdAt: String? = null
    @JsonProperty("reference_code")
    @get:JsonProperty("reference_code")
    @set:JsonProperty("reference_code")
    var referenceCode: String? = null
    @JsonProperty("contact_id")
    @get:JsonProperty("contact_id")
    @set:JsonProperty("contact_id")
    var contactId: Int? = null
    @JsonProperty("seller")
    @get:JsonProperty("seller")
    @set:JsonProperty("seller")
    var seller: Seller? = null
    @JsonProperty("currency")
    @get:JsonProperty("currency")
    @set:JsonProperty("currency")
    var currency: String? = null
    @JsonProperty("amount")
    @get:JsonProperty("amount")
    @set:JsonProperty("amount")
    var amount: String = ""
    @JsonProperty("is_selling")
    @get:JsonProperty("is_selling")
    @set:JsonProperty("is_selling")
    var isSelling: Boolean? = null
    @JsonProperty("escrowed_at")
    @get:JsonProperty("escrowed_at")
    @set:JsonProperty("escrowed_at")
    var escrowedAt: String? = null
    @JsonProperty("amount_btc")
    @get:JsonProperty("amount_btc")
    @set:JsonProperty("amount_btc")
    var amountBtc: String = ""
    @JsonProperty("canceled_at")
    @get:JsonProperty("canceled_at")
    @set:JsonProperty("canceled_at")
    var canceledAt: String? = null
    @JsonProperty("buyer")
    @get:JsonProperty("buyer")
    @set:JsonProperty("buyer")
    var buyer: Buyer? = null
    @JsonProperty("closed_at")
    @get:JsonProperty("closed_at")
    @set:JsonProperty("closed_at")
    var closedAt: String? = null
    @JsonProperty("funded_at")
    @get:JsonProperty("funded_at")
    @set:JsonProperty("funded_at")
    var fundedAt: String? = null
    @JsonProperty("account_info")
    @get:JsonProperty("account_info")
    @set:JsonProperty("account_info")
    var accountInfo: String? = null
    @JsonProperty("fee_btc")
    @get:JsonProperty("fee_btc")
    @set:JsonProperty("fee_btc")
    var feeBtc: String? = null
    @JsonProperty("payment_completed_at")
    @get:JsonProperty("payment_completed_at")
    @set:JsonProperty("payment_completed_at")
    var paymentCompletedAt: String? = null
    @JsonProperty("released_at")
    @get:JsonProperty("released_at")
    @set:JsonProperty("released_at")
    var releasedAt: String? = null
    @JsonIgnore
    private val additionalProperties = HashMap<String, Any?>()

    @JsonAnyGetter
    fun getAdditionalProperties(): Map<String, Any?> {
        return this.additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any?) {
        this.additionalProperties[name] = value
    }

}
