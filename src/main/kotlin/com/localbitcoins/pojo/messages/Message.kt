package com.localbitcoins.pojo.messages

import com.localbitcoins.pojo.Profile
import java.util.*

data class Message(
    val msg: String,
    val sender: Profile,
    val createdAt: Date = Date(),
    val isAdmin: Boolean = false,
    val attachmentName: String? = null,
    val attachmentType: String? = null,
    val attachmentUrl: String? = null
)
