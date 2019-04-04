package com.localbitcoins.pojo.dashboard

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Contact (
    @JsonProperty("data")
    val data: ContactData,
    @JsonProperty("actions")
    val actions: Actions
): Serializable
