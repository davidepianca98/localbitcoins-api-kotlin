package com.localbitcoins

import com.localbitcoins.pojo.dashboard.Contact
import com.localbitcoins.pojo.messages.ContactMessages

fun Contact.getContactMessages(localBitcoinsUtils: LocalBitcoinsUtils): ContactMessages {
    return localBitcoinsUtils.getContactMessages(this.data.contactId.toString())
}