package com.localbitcoins.pojo.accountinfo

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class AccountInfo(val data: Data)