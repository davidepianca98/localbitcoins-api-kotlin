package com.localbitcoins.pojo.dashboard

import java.io.Serializable

data class Actions(
    val messagePostUrl: String? = null,
    val advertisementUrl: String? = null,
    val messagesUrl: String? = null,
    val releaseUrl: String? = null,
    val disputeUrl: String? = null,
    val cancelUrl: String? = null,
    val advertisementPublicView: String? = null
) : Serializable
