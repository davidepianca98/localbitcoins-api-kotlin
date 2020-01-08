package com.localbitcoins.pojo.dashboard

import com.localbitcoins.pojo.Profile
import com.localbitcoins.pojo.accountdetails.AccountDetails
import java.io.Serializable
import java.math.BigDecimal
import java.util.*

data class ContactData(
    val exchangeRateUpdatedAt: Date,
    val advertisement: Advertisement,
    val isBuying: Boolean,
    val createdAt: Date,
    val referenceCode: String,
    val contactId: Long,
    val seller: Profile,
    val currency: String,
    val amount: BigDecimal,
    val isSelling: Boolean,
    val escrowedAt: Date?,
    val amountBtc: BigDecimal,
    val canceledAt: Date? = null,
    val buyer: Profile,
    val closedAt: Date? = null,
    val fundedAt: Date? = null,
    val accountDetails: AccountDetails? = null,
    val accountInfo: String? = null,
    val feeBtc: BigDecimal,
    val paymentCompletedAt: Date? = null,
    val releasedAt: Date? = null,
    val disputedAt: Date? = null,
    val floating: Boolean
) : Serializable
