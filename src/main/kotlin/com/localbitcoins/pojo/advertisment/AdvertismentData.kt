package com.localbitcoins.pojo.advertisment

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.localbitcoins.pojo.Profile

@JsonInclude(JsonInclude.Include.NON_NULL)
data class AdvertismentData (
    @JsonProperty("profile")
    val profile: Profile,
    @JsonProperty("require_feedback_score")
    val requireFeedbackScore: Int,
    @JsonProperty("hidden_by_opening_hours")
    val hiddenByOpeningHours: Boolean,
    @JsonProperty("trade_type")
    val tradeType: String,
    @JsonProperty("ad_id")
    val adId: Int,
    @JsonProperty("temp_price")
    val tempPrice: String,
    @JsonProperty("bank_name")
    val bankName: String,
    @JsonProperty("payment_window_minutes")
    val paymentWindowMinutes: Int,
    @JsonProperty("trusted_required")
    val trustedRequired: Boolean,
    @JsonProperty("min_amount")
    val minAmount: String?,
    @JsonProperty("account_info")
    val accountInfo: String,
    @JsonProperty("visible")
    val visible: Boolean,
    @JsonProperty("reference_type")
    val referenceType: String,
    @JsonProperty("require_trusted_by_advertiser")
    val requireTrustedByAdvertiser: Boolean,
    @JsonProperty("track_max_amount")
    val trackMaxAmount: Boolean,
    @JsonProperty("temp_price_usd")
    val tempPriceUsd: String,
    @JsonProperty("lat")
    val lat: Double,
    @JsonProperty("is_local_office")
    val isLocalOffice: Boolean,
    @JsonProperty("price_equation")
    val priceEquation: String,
    @JsonProperty("first_time_limit_btc")
    val firstTimeLimitBtc: String,
    @JsonProperty("city")
    val city: String,
    @JsonProperty("location_string")
    val locationString: String,
    @JsonProperty("countrycode")
    val countrycode: String,
    @JsonProperty("currency")
    val currency: String,
    @JsonProperty("limit_to_fiat_amounts")
    val limitToFiatAmounts: String,
    @JsonProperty("created_at")
    val createdAt: String,
    @JsonProperty("max_amount")
    val maxAmount: String?,
    @JsonProperty("lon")
    val lon: Double,
    @JsonProperty("display_reference")
    val displayReference: Boolean,
    @JsonProperty("sms_verification_required")
    val smsVerificationRequired: Boolean,
    @JsonProperty("require_trade_volume")
    val requireTradeVolume: Double,
    @JsonProperty("online_provider")
    val onlineProvider: String,
    @JsonProperty("max_amount_available")
    val maxAmountAvailable: String,
    @JsonProperty("opening_hours")
    val openingHours: String,
    @JsonProperty("msg")
    val msg: String,
    @JsonProperty("require_identification")
    val requireIdentification: Boolean,
    @JsonProperty("volume_coefficient_btc")
    val volumeCoefficientBtc: String,
    @JsonProperty("atm_model")
    val atmModel: String?
)
