package com.localbitcoins.pojo.wallet

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Wallet (@JsonProperty("data") val data: Data)
