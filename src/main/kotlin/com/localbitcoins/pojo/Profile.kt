package com.localbitcoins.pojo

import java.io.Serializable
import java.util.*

data class Profile (
    val username: String,
    val feedbackScore: Int,
    val name: String,
    val lastOnline: Date,
    val tradeCount: String,
    val countrycodeByPhoneNumber: String? = null,
    val realName: String? = null,
    val countrycodeByIp: String? = null,
    val companyName: String? = null
): Serializable
