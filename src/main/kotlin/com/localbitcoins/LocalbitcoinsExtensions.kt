package com.localbitcoins

import com.localbitcoins.pojo.dashboard.Contact
import com.localbitcoins.pojo.messages.ContactMessages

suspend fun Contact.getContactMessages(localBitcoinsUtils: LocalBitcoinsUtils): ContactMessages {
    return localBitcoinsUtils.getContactMessages(this.data.contactId.toString())
}

enum class ContactOpenState {
    AWAITING_PAYMENT,
    MARKED_PAYED,
    DISPUTED
}

val Contact.state: ContactOpenState
    get() {
        return when {
            data.disputedAt != null -> ContactOpenState.DISPUTED
            data.paymentCompletedAt != null -> ContactOpenState.MARKED_PAYED
            else -> ContactOpenState.AWAITING_PAYMENT
        }
    }
