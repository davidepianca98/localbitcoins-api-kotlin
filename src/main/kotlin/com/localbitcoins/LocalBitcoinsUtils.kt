package com.localbitcoins

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import com.localbitcoins.pojo.accountinfo.AccountInfo
import com.localbitcoins.pojo.advertisment.Advertisements
import com.localbitcoins.pojo.advertisment.Advertisment
import com.localbitcoins.pojo.dashboard.Contact
import com.localbitcoins.pojo.dashboard.LocalBitcoinsDashboard
import com.localbitcoins.pojo.fees.Fees
import com.localbitcoins.pojo.messages.ContactMessages
import com.localbitcoins.pojo.wallet.Wallet
import com.localbitcoins.pojo.wallet.WalletSend
import java.math.BigDecimal
import java.net.URLDecoder
import java.util.*

class LocalBitcoinsUtils(private val localBitcoinsKey: String, private val localBitcoinsSecret: String) {

    private val objectMapper = ObjectMapper().registerModule(KotlinModule())

    suspend fun getAd(adId: Int): Advertisment {
        val data = LocalBitcoinsRequest.get(
            localBitcoinsKey,
            localBitcoinsSecret,
            LocalBitcoinsRequest.AD_GET + "$adId/",
            null,
            LocalBitcoinsRequest.HttpType.GET
        )

        val advertisements = objectMapper.readValue<Advertisements>(data)
        return advertisements.advertismentsData.advertismentList[0]
    }

    suspend fun getTransaction(transactionId: String): Contact {
        val data = LocalBitcoinsRequest.get(
            localBitcoinsKey,
            localBitcoinsSecret,
            LocalBitcoinsRequest.CONTACT_INFO + "$transactionId/",
            null,
            LocalBitcoinsRequest.HttpType.GET
        )

        return objectMapper.readValue(data)
    }

    suspend fun getTransactionListUntil(transactionId: String): List<Contact> {
        var url = LocalBitcoinsRequest.RELEASED
        val contacts = ArrayList<Contact>()

        while (true) {
            val data = LocalBitcoinsRequest.get(
                localBitcoinsKey,
                localBitcoinsSecret,
                url,
                null,
                LocalBitcoinsRequest.HttpType.GET
            )

            val localBitcoinsDashboard = objectMapper.readValue<LocalBitcoinsDashboard>(data)
            for (contact in localBitcoinsDashboard.data.contact) {
                if (contact.data.releasedAt != null && contact.data.isSelling) {
                    if (contact.data.contactId == Integer.parseInt(transactionId)) {
                        // Reverse the transaction list to get them from oldest to newest
                        contacts.reverse()
                        return contacts
                    }
                    contacts.add(contact)
                    println(contact.data.releasedAt)
                }
            }
            url = localBitcoinsDashboard.pagination!!.next!!
        }
    }

    suspend fun getTransactionListUntil(date: Date): List<Contact> {
        var url = LocalBitcoinsRequest.RELEASED
        val contacts = ArrayList<Contact>()

        while (true) {
            val data = LocalBitcoinsRequest.get(
                localBitcoinsKey,
                localBitcoinsSecret,
                url,
                null,
                LocalBitcoinsRequest.HttpType.GET
            )

            val localBitcoinsDashboard = objectMapper.readValue<LocalBitcoinsDashboard>(data)
            for (contact in localBitcoinsDashboard.data.contact) {
                if (contact.data.isSelling) {
                    if (contact.data.releasedAt!! < date) {
                        // Reverse the transaction list to get them from oldest to newest
                        contacts.reverse()
                        return contacts
                    }
                    contacts.add(contact)
                    println(contact.data.releasedAt)
                }
            }
            url = localBitcoinsDashboard.pagination!!.next!!
        }
    }

    suspend fun getOpenTransactions(): List<Contact> {
        val contacts = ArrayList<Contact>()
        var url = LocalBitcoinsRequest.DASHBOARD

        while (true) {
            val data = LocalBitcoinsRequest.get(
                localBitcoinsKey,
                localBitcoinsSecret,
                url,
                null,
                LocalBitcoinsRequest.HttpType.GET
            )

            val localBitcoinsDashboard = objectMapper.readValue<LocalBitcoinsDashboard>(data)
            for (contact in localBitcoinsDashboard.data.contact) {
                if (contact.data.isSelling) {
                    contacts.add(contact)
                }
            }
            if (localBitcoinsDashboard.pagination?.next == null) {
                return contacts
            }
            url = URLDecoder.decode(localBitcoinsDashboard.pagination.next, "UTF-8")
        }
    }

    suspend fun getWallet(): Wallet {
        val data = LocalBitcoinsRequest.get(
            localBitcoinsKey,
            localBitcoinsSecret,
            LocalBitcoinsRequest.WALLET,
            null,
            LocalBitcoinsRequest.HttpType.GET
        )

        return objectMapper.readValue(data)
    }

    suspend fun walletSend(address: String, amount: BigDecimal): WalletSend {
        val parameterCollection = listOf(Pair("address", address), Pair("amount", amount.toString()))
        val data = LocalBitcoinsRequest.get(
            localBitcoinsKey,
            localBitcoinsSecret,
            LocalBitcoinsRequest.WALLET_SEND,
            parameterCollection,
            LocalBitcoinsRequest.HttpType.POST
        )

        return objectMapper.readValue(data)
    }

    suspend fun getFees(): Fees {
        val data = LocalBitcoinsRequest.get(
            localBitcoinsKey,
            localBitcoinsSecret,
            LocalBitcoinsRequest.FEES,
            null,
            LocalBitcoinsRequest.HttpType.GET
        )

        return objectMapper.readValue(data)
    }

    suspend fun getContactMessages(contactId: String): ContactMessages {
        val data = LocalBitcoinsRequest.get(
            localBitcoinsKey,
            localBitcoinsSecret,
            LocalBitcoinsRequest.CONTACT_MESSAGES + "$contactId/",
            null,
            LocalBitcoinsRequest.HttpType.GET
        )

        return objectMapper.readValue(data)
    }

    suspend fun contactMessagePost(contactId: String, message: String): String {
        val parameterCollection = listOf(Pair("msg", message))
        return LocalBitcoinsRequest.get(
            localBitcoinsKey,
            localBitcoinsSecret,
            LocalBitcoinsRequest.CONTACT_MESSAGE_POST + "$contactId/",
            parameterCollection,
            LocalBitcoinsRequest.HttpType.POST
        )
    }

    suspend fun contactRelease(contactId: String): String {
        return LocalBitcoinsRequest.get(
            localBitcoinsKey,
            localBitcoinsSecret,
            LocalBitcoinsRequest.CONTACT_RELEASE + "$contactId/",
            null,
            LocalBitcoinsRequest.HttpType.POST
        )
    }

    suspend fun getAccountInfo(username: String): AccountInfo {
        val data = LocalBitcoinsRequest.get(
            localBitcoinsKey,
            localBitcoinsSecret,
            LocalBitcoinsRequest.ACCOUNT_INFO + "$username/",
            null,
            LocalBitcoinsRequest.HttpType.GET
        )
        return objectMapper.readValue(data)
    }

    suspend fun getMyself(): AccountInfo {
        val data = LocalBitcoinsRequest.get(
            localBitcoinsKey,
            localBitcoinsSecret,
            LocalBitcoinsRequest.MYSELF,
            null,
            LocalBitcoinsRequest.HttpType.GET
        )
        return objectMapper.readValue(data)
    }
}
