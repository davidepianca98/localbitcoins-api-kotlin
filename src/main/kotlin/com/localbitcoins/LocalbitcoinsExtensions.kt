package com.localbitcoins

import com.localbitcoins.pojo.dashboard.Contact
import com.localbitcoins.pojo.messages.ContactMessages

fun Contact.getContactMessages(
    localBitcoinsKey: String,
    localBitcoinsSecret: String
): ContactMessages {
    return LocalBitcoinsUtils.getContactMessages(localBitcoinsKey, localBitcoinsSecret, this.data.contactId.toString())
}