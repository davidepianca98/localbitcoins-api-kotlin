package com.localbitcoins.pojo.accountinfo

import java.util.*

data class Data(
    val username: String,
    val feedbackScore: String,
    val feedbackCount: Int,
    val realNameVerificationsTrusted: Int,
    val tradingPartnersCount: Int,
    val url: String,
    val realNameVerificationsUntrusted: Int,
    val hasFeedback: Boolean,
    val identityVerifiedAt: Date?,
    val trustedCount: Int,
    val feedbacksUnconfirmedCount: Int,
    val blockedCount: Int,
    val myFeedback: String? = null,
    val myFeedbackMsg: String? = null,
    val tradeVolumeText: String,
    val hasCommonTrades: Boolean,
    val realNameVerificationsRejected: Int,
    val ageText: String,
    val confirmedTradeCountText: String,
    val createdAt: Date
)
