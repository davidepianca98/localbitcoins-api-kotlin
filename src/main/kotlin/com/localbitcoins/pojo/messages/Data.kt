package com.localbitcoins.pojo.messages

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Data (
    @JsonProperty("message_count")
    val messageCount: Int,
    @JsonProperty("message_list")
    val messageList: List<MessageList>
)
