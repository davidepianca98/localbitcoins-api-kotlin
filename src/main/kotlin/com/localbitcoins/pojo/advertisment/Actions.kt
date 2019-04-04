package com.localbitcoins.pojo.advertisment

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Actions (
    @JsonProperty("html_form")
    val htmlForm: String?,
    @JsonProperty("public_view")
    val publicView: String?,
    @JsonProperty("change_form")
    val changeForm: String?
)
