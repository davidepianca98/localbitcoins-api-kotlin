package com.localbitcoins.pojo.dashboard

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.localbitcoins.pojo.Profile
import com.localbitcoins.pojo.accountdetails.AccountDetails
import java.io.Serializable
import java.math.BigDecimal
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ContactData(
    @JsonProperty("exchange_rate_updated_at")
    val exchangeRateUpdatedAt: Date,
    @JsonProperty("advertisement")
    val advertisement: Advertisement,
    @JsonProperty("is_buying")
    val isBuying: Boolean,
    @JsonProperty("created_at")
    val createdAt: Date,
    @JsonProperty("reference_code")
    val referenceCode: String,
    @JsonProperty("contact_id")
    val contactId: Int,
    @JsonProperty("seller")
    val seller: Profile,
    @JsonProperty("currency")
    val currency: String,
    @JsonProperty("amount")
    val amount: BigDecimal,
    @JsonProperty("is_selling")
    val isSelling: Boolean,
    @JsonProperty("escrowed_at")
    val escrowedAt: Date?,
    @JsonProperty("amount_btc")
    val amountBtc: BigDecimal,
    @JsonProperty("canceled_at")
    val canceledAt: Date? = null,
    @JsonProperty("buyer")
    val buyer: Profile,
    @JsonProperty("closed_at")
    val closedAt: Date? = null,
    @JsonProperty("funded_at")
    val fundedAt: Date? = null,
    @JsonProperty("account_details")
    val accountDetails: AccountDetails? = null,
    @JsonProperty("account_info")
    val accountInfo: String? = null,
    @JsonProperty("fee_btc")
    val feeBtc: BigDecimal,
    @JsonProperty("payment_completed_at")
    val paymentCompletedAt: Date? = null,
    @JsonProperty("released_at")
    val releasedAt: Date? = null,
    @JsonProperty("disputed_at")
    val disputedAt: Date? = null,
    @JsonProperty("floating")
    val floating: Boolean
) : Serializable
