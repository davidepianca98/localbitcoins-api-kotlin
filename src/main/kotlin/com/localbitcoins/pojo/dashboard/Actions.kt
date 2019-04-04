package com.localbitcoins.pojo.dashboard

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Actions (
    @JsonProperty("message_post_url")
    val messagePostUrl: String?,
    @JsonProperty("advertisement_url")
    val advertisementUrl: String?,
    @JsonProperty("messages_url")
    val messagesUrl: String?,
    @JsonProperty("release_url")
    val releaseUrl: String?,
    @JsonProperty("advertisement_public_view")
    val advertisementPublicView: String?
): Serializable
