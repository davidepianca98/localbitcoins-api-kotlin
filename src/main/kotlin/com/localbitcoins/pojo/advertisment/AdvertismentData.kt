package com.localbitcoins.pojo.advertisment

import com.fasterxml.jackson.annotation.*
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
    "profile",
    "require_feedback_score",
    "hidden_by_opening_hours",
    "trade_type",
    "ad_id",
    "temp_price",
    "bank_name",
    "payment_window_minutes",
    "trusted_required",
    "min_amount",
    "account_info",
    "visible",
    "reference_type",
    "require_trusted_by_advertiser",
    "track_max_amount",
    "temp_price_usd",
    "lat",
    "is_local_office",
    "price_equation",
    "first_time_limit_btc",
    "city",
    "location_string",
    "countrycode",
    "currency",
    "limit_to_fiat_amounts",
    "created_at",
    "max_amount",
    "lon",
    "display_reference",
    "sms_verification_required",
    "require_trade_volume",
    "online_provider",
    "max_amount_available",
    "opening_hours",
    "msg",
    "require_identification",
    "volume_coefficient_btc"
)
class AdvertismentData {

    @JsonProperty("profile")
    @get:JsonProperty("profile")
    @set:JsonProperty("profile")
    var profile: Profile? = null
    @JsonProperty("require_feedback_score")
    @get:JsonProperty("require_feedback_score")
    @set:JsonProperty("require_feedback_score")
    var requireFeedbackScore: Int? = null
    @JsonProperty("hidden_by_opening_hours")
    @get:JsonProperty("hidden_by_opening_hours")
    @set:JsonProperty("hidden_by_opening_hours")
    var hiddenByOpeningHours: Boolean? = null
    @JsonProperty("trade_type")
    @get:JsonProperty("trade_type")
    @set:JsonProperty("trade_type")
    var tradeType: String? = null
    @JsonProperty("ad_id")
    @get:JsonProperty("ad_id")
    @set:JsonProperty("ad_id")
    var adId: Int? = null
    @JsonProperty("temp_price")
    @get:JsonProperty("temp_price")
    @set:JsonProperty("temp_price")
    var tempPrice: String? = null
    @JsonProperty("bank_name")
    @get:JsonProperty("bank_name")
    @set:JsonProperty("bank_name")
    var bankName: String? = null
    @JsonProperty("payment_window_minutes")
    @get:JsonProperty("payment_window_minutes")
    @set:JsonProperty("payment_window_minutes")
    var paymentWindowMinutes: Int? = null
    @JsonProperty("trusted_required")
    @get:JsonProperty("trusted_required")
    @set:JsonProperty("trusted_required")
    var trustedRequired: Boolean? = null
    @JsonProperty("min_amount")
    @get:JsonProperty("min_amount")
    @set:JsonProperty("min_amount")
    var minAmount: String? = null
    @JsonProperty("account_info")
    @get:JsonProperty("account_info")
    @set:JsonProperty("account_info")
    var accountInfo: String? = null
    @JsonProperty("visible")
    @get:JsonProperty("visible")
    @set:JsonProperty("visible")
    var visible: Boolean? = null
    @JsonProperty("reference_type")
    @get:JsonProperty("reference_type")
    @set:JsonProperty("reference_type")
    var referenceType: String? = null
    @JsonProperty("require_trusted_by_advertiser")
    @get:JsonProperty("require_trusted_by_advertiser")
    @set:JsonProperty("require_trusted_by_advertiser")
    var requireTrustedByAdvertiser: Boolean? = null
    @JsonProperty("track_max_amount")
    @get:JsonProperty("track_max_amount")
    @set:JsonProperty("track_max_amount")
    var trackMaxAmount: Boolean? = null
    @JsonProperty("temp_price_usd")
    @get:JsonProperty("temp_price_usd")
    @set:JsonProperty("temp_price_usd")
    var tempPriceUsd: String? = null
    @JsonProperty("lat")
    @get:JsonProperty("lat")
    @set:JsonProperty("lat")
    var lat: Double? = null
    @JsonProperty("is_local_office")
    @get:JsonProperty("is_local_office")
    @set:JsonProperty("is_local_office")
    var isLocalOffice: Boolean? = null
    @JsonProperty("price_equation")
    @get:JsonProperty("price_equation")
    @set:JsonProperty("price_equation")
    var priceEquation: String? = null
    @JsonProperty("first_time_limit_btc")
    @get:JsonProperty("first_time_limit_btc")
    @set:JsonProperty("first_time_limit_btc")
    var firstTimeLimitBtc: String? = null
    @JsonProperty("city")
    @get:JsonProperty("city")
    @set:JsonProperty("city")
    var city: String? = null
    @JsonProperty("location_string")
    @get:JsonProperty("location_string")
    @set:JsonProperty("location_string")
    var locationString: String? = null
    @JsonProperty("countrycode")
    @get:JsonProperty("countrycode")
    @set:JsonProperty("countrycode")
    var countrycode: String? = null
    @JsonProperty("currency")
    @get:JsonProperty("currency")
    @set:JsonProperty("currency")
    var currency: String? = null
    @JsonProperty("limit_to_fiat_amounts")
    @get:JsonProperty("limit_to_fiat_amounts")
    @set:JsonProperty("limit_to_fiat_amounts")
    var limitToFiatAmounts: String? = null
    @JsonProperty("created_at")
    @get:JsonProperty("created_at")
    @set:JsonProperty("created_at")
    var createdAt: String? = null
    @JsonProperty("max_amount")
    @get:JsonProperty("max_amount")
    @set:JsonProperty("max_amount")
    var maxAmount: String? = null
    @JsonProperty("lon")
    @get:JsonProperty("lon")
    @set:JsonProperty("lon")
    var lon: Double? = null
    @JsonProperty("display_reference")
    @get:JsonProperty("display_reference")
    @set:JsonProperty("display_reference")
    var displayReference: Boolean? = null
    @JsonProperty("sms_verification_required")
    @get:JsonProperty("sms_verification_required")
    @set:JsonProperty("sms_verification_required")
    var smsVerificationRequired: Boolean? = null
    @JsonProperty("require_trade_volume")
    @get:JsonProperty("require_trade_volume")
    @set:JsonProperty("require_trade_volume")
    var requireTradeVolume: Double? = null
    @JsonProperty("online_provider")
    @get:JsonProperty("online_provider")
    @set:JsonProperty("online_provider")
    var onlineProvider: String? = null
    @JsonProperty("max_amount_available")
    @get:JsonProperty("max_amount_available")
    @set:JsonProperty("max_amount_available")
    var maxAmountAvailable: String? = null
    @JsonProperty("opening_hours")
    @get:JsonProperty("opening_hours")
    @set:JsonProperty("opening_hours")
    var openingHours: String? = null
    @JsonProperty("msg")
    @get:JsonProperty("msg")
    @set:JsonProperty("msg")
    var msg: String? = null
    @JsonProperty("require_identification")
    @get:JsonProperty("require_identification")
    @set:JsonProperty("require_identification")
    var requireIdentification: Boolean? = null
    @JsonProperty("volume_coefficient_btc")
    @get:JsonProperty("volume_coefficient_btc")
    @set:JsonProperty("volume_coefficient_btc")
    var volumeCoefficientBtc: String? = null
    @JsonIgnore
    var additionalProperties = HashMap<String, Any?>()

    @JsonAnyGetter
    fun getAdditionalProperties(): Map<String, Any?> {
        return this.additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any?) {
        this.additionalProperties[name] = value
    }

}
