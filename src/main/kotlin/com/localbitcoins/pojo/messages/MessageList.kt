package com.localbitcoins.pojo.messages

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class MessageList (
    @JsonProperty("msg")
    val msg: String,
    @JsonProperty("created_at")
    val createdAt: String,
    @JsonProperty("is_admin")
    val isAdmin: Boolean,
    @JsonProperty("sender")
    val sender: Sender,
    @JsonProperty("attachment_name")
    val attachmentName: String?,
    @JsonProperty("attachment_type")
    val attachmentType: String?,
    @JsonProperty("attachment_url")
    val attachmentUrl: String?
)
