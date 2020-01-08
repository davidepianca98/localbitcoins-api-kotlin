package com.localbitcoins.pojo.dashboard

import java.io.Serializable

data class Contact(
    val data: ContactData,
    val actions: Actions
) : Serializable
