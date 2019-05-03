package com.localbitcoins.pojo.messages

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.localbitcoins.pojo.Profile
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Message(
    @JsonProperty("msg")
    val msg: String,
    @JsonProperty("sender")
    val sender: Profile,
    @JsonProperty("created_at")
    val createdAt: Date = Date(),
    @JsonProperty("is_admin")
    val isAdmin: Boolean = false,
    @JsonProperty("attachment_name")
    val attachmentName: String? = null,
    @JsonProperty("attachment_type")
    val attachmentType: String? = null,
    @JsonProperty("attachment_url")
    val attachmentUrl: String? = null
)
