package com.localbitcoins

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
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
import org.apache.http.client.utils.URLEncodedUtils
import org.apache.http.message.BasicNameValuePair
import java.io.IOException
import java.net.URI
import java.net.URISyntaxException
import java.nio.charset.Charset
import java.util.*
import kotlin.collections.ArrayList

class LocalBitcoinsUtils {

    companion object {

        private val objectMapper = ObjectMapper().registerModule(KotlinModule())

        @Throws(JsonParseException::class, JsonMappingException::class, IOException::class)
        fun getAd(adId: Int?, localBitcoinsKey: String, localBitcoinsSecret: String): Advertisment {
            val parameterCollection = ParameterCollection(ArrayList())
            val request = LocalBitcoinsRequest(
                localBitcoinsKey,
                localBitcoinsSecret,
                "/ad-get/$adId/",
                parameterCollection,
                LocalBitcoinsRequest.HttpType.GET
            )
            val data = request.get()

            val advertisements = objectMapper.readValue<Advertisements>(data)
            return advertisements.advertismentsData.advertismentList[0]
        }

        @Throws(JsonParseException::class, JsonMappingException::class, IOException::class)
        fun getTransaction(transactionId: String, localBitcoinsKey: String, localBitcoinsSecret: String): Contact {
            val parameterCollection = ParameterCollection(ArrayList())
            val request = LocalBitcoinsRequest(
                localBitcoinsKey,
                localBitcoinsSecret,
                "/contact_info/$transactionId/",
                parameterCollection,
                LocalBitcoinsRequest.HttpType.GET
            )
            val data = request.get()
            return objectMapper.readValue(data)
        }

        @Throws(URISyntaxException::class, JsonParseException::class, JsonMappingException::class, IOException::class)
        fun getTransactionListUntil(
            transactionId: String,
            localBitcoinsKey: String,
            localBitcoinsSecret: String
        ): List<Contact> {
            var parameterCollection = ParameterCollection(ArrayList())
            val contacts = ArrayList<Contact>()

            while (true) {
                val request = LocalBitcoinsRequest(
                    localBitcoinsKey,
                    localBitcoinsSecret,
                    LocalBitcoinsRequest.RELEASED,
                    parameterCollection,
                    LocalBitcoinsRequest.HttpType.GET
                )
                val data = request.get()

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
                val nextUrl = localBitcoinsDashboard.pagination!!.next!!
                parameterCollection =
                    ParameterCollection(URLEncodedUtils.parse(URI(nextUrl), Charset.forName("UTF-8")))
            }
        }

        @Throws(URISyntaxException::class, JsonParseException::class, JsonMappingException::class, IOException::class)
        fun getTransactionListUntil(
            date: Date,
            localBitcoinsKey: String,
            localBitcoinsSecret: String
        ): List<Contact> {
            var parameterCollection = ParameterCollection(ArrayList())
            val contacts = ArrayList<Contact>()

            while (true) {
                val request = LocalBitcoinsRequest(
                    localBitcoinsKey,
                    localBitcoinsSecret,
                    LocalBitcoinsRequest.RELEASED,
                    parameterCollection,
                    LocalBitcoinsRequest.HttpType.GET
                )
                var data: String
                try {
                    data = request.get()
                } catch (e: IOException) {
                    continue
                }

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
                val nextUrl = localBitcoinsDashboard.pagination!!.next!!
                parameterCollection =
                    ParameterCollection(URLEncodedUtils.parse(URI(nextUrl), Charset.forName("UTF-8")))
            }
        }

        @Throws(URISyntaxException::class, JsonParseException::class, JsonMappingException::class, IOException::class)
        fun getOpenTransactions(localBitcoinsKey: String, localBitcoinsSecret: String): List<Contact> {
            var parameterCollection = ParameterCollection(ArrayList())
            val contacts = ArrayList<Contact>()

            while (true) {
                val request = LocalBitcoinsRequest(
                    localBitcoinsKey,
                    localBitcoinsSecret,
                    LocalBitcoinsRequest.DASHBOARD,
                    parameterCollection,
                    LocalBitcoinsRequest.HttpType.GET
                )
                val data = request.get()

                val localBitcoinsDashboard = objectMapper.readValue<LocalBitcoinsDashboard>(data)
                for (contact in localBitcoinsDashboard.data.contact) {
                    if (contact.data.isSelling) {
                        contacts.add(contact)
                    }
                }
                if (localBitcoinsDashboard.pagination?.next == null) {
                    // Reverse the transaction list to get them from oldest to newest
                    // contacts.reverse() // TODO check
                    return contacts
                }
                parameterCollection =
                    ParameterCollection(
                        URLEncodedUtils.parse(
                            URI(localBitcoinsDashboard.pagination.next),
                            Charset.forName("UTF-8")
                        )
                    )
            }
        }

        @Throws(JsonParseException::class, JsonMappingException::class, IOException::class)
        fun getWallet(localBitcoinsKey: String, localBitcoinsSecret: String): Wallet {
            val parameterCollection = ParameterCollection(ArrayList())
            val request = LocalBitcoinsRequest(
                localBitcoinsKey,
                localBitcoinsSecret,
                LocalBitcoinsRequest.WALLET,
                parameterCollection,
                LocalBitcoinsRequest.HttpType.GET
            )
            val data = request.get()
            return objectMapper.readValue(data)
        }

        @Throws(JsonParseException::class, JsonMappingException::class, IOException::class)
        fun getFees(localBitcoinsKey: String, localBitcoinsSecret: String): Fees {
            val parameterCollection = ParameterCollection(ArrayList())
            val request = LocalBitcoinsRequest(
                localBitcoinsKey,
                localBitcoinsSecret,
                LocalBitcoinsRequest.FEES,
                parameterCollection,
                LocalBitcoinsRequest.HttpType.GET
            )
            val data = request.get()
            return objectMapper.readValue(data)
        }

        @Throws(JsonParseException::class, JsonMappingException::class, IOException::class)
        fun getContactMessages(
            localBitcoinsKey: String,
            localBitcoinsSecret: String,
            contactId: String
        ): ContactMessages {
            val parameterCollection = ParameterCollection(ArrayList())
            val request = LocalBitcoinsRequest(
                localBitcoinsKey,
                localBitcoinsSecret,
                "/contact_messages/$contactId/",
                parameterCollection,
                LocalBitcoinsRequest.HttpType.GET
            )
            val data = request.get()
            return objectMapper.readValue(data)
        }

        @Throws(IOException::class)
        fun contactMessagePost(
            localBitcoinsKey: String,
            localBitcoinsSecret: String,
            contactId: String,
            message: String
        ): String {
            val parameterCollection = ParameterCollection(ArrayList())
            parameterCollection.add(BasicNameValuePair("msg", message))
            val request = LocalBitcoinsRequest(
                localBitcoinsKey,
                localBitcoinsSecret,
                "/contact_message_post/$contactId/",
                parameterCollection,
                LocalBitcoinsRequest.HttpType.POST
            )
            return request.get()
        }

        @Throws(IOException::class)
        fun contactRelease(localBitcoinsKey: String, localBitcoinsSecret: String, contactId: String): String {
            val parameterCollection = ParameterCollection(ArrayList())
            val request = LocalBitcoinsRequest(
                localBitcoinsKey,
                localBitcoinsSecret,
                "/contact_release/$contactId/",
                parameterCollection,
                LocalBitcoinsRequest.HttpType.POST
            )
            return request.get()
        }

        @Throws(IOException::class)
        fun getAccountInfo(localBitcoinsKey: String, localBitcoinsSecret: String, username: String): AccountInfo {
            val parameterCollection = ParameterCollection(ArrayList())
            val request = LocalBitcoinsRequest(
                localBitcoinsKey,
                localBitcoinsSecret,
                "/account_info/$username/",
                parameterCollection,
                LocalBitcoinsRequest.HttpType.GET
            )
            return objectMapper.readValue(request.get())
        }
    }
}
