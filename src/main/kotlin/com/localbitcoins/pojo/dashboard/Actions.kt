package com.localbitcoins.pojo.dashboard

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Actions(
    @JsonProperty("message_post_url")
    val messagePostUrl: String? = null,
    @JsonProperty("advertisement_url")
    val advertisementUrl: String? = null,
    @JsonProperty("messages_url")
    val messagesUrl: String? = null,
    @JsonProperty("release_url")
    val releaseUrl: String? = null,
    @JsonProperty("dispute_url")
    val disputeUrl: String? = null,
    @JsonProperty("cancel_url")
    val cancelUrl: String? = null,
    @JsonProperty("advertisement_public_view")
    val advertisementPublicView: String? = null
) : Serializable
