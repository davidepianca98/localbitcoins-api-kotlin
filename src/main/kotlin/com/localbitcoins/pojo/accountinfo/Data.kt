package com.localbitcoins.pojo.accountinfo

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Data(
    @JsonProperty("username")
    val username: String,
    @JsonProperty("feedback_score")
    val feedbackScore: String,
    @JsonProperty("feedback_count")
    val feedbackCount: Int,
    @JsonProperty("real_name_verifications_trusted")
    val realNameVerificationsTrusted: Int,
    @JsonProperty("trading_partners_count")
    val tradingPartnersCount: Int,
    @JsonProperty("url")
    val url: String,
    @JsonProperty("real_name_verifications_untrusted")
    val realNameVerificationsUntrusted: Int,
    @JsonProperty("has_feedback")
    val hasFeedback: Boolean,
    @JsonProperty("identity_verified_at")
    val identityVerifiedAt: Date?,
    @JsonProperty("trusted_count")
    val trustedCount: Int,
    @JsonProperty("feedbacks_unconfirmed_count")
    val feedbacksUnconfirmedCount: Int,
    @JsonProperty("blocked_count")
    val blockedCount: Int,
    @JsonProperty("my_feedback")
    val myFeedback: String?,
    @JsonProperty("trade_volume_text")
    val tradeVolumeText: String,
    @JsonProperty("has_common_trades")
    val hasCommonTrades: Boolean,
    @JsonProperty("real_name_verifications_rejected")
    val realNameVerificationsRejected: Int,
    @JsonProperty("age_text")
    val ageText: String,
    @JsonProperty("confirmed_trade_count_text")
    val confirmedTradeCountText: String,
    @JsonProperty("created_at")
    val createdAt: Date
)