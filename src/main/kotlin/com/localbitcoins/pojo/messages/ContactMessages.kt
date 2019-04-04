package com.localbitcoins.pojo.messages

import com.fasterxml.jackson.annotation.*
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ContactMessages(val data: Data)
