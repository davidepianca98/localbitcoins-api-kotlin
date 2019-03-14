package com.localbitcoins

import com.fasterxml.jackson.databind.ObjectMapper
import com.localbitcoins.pojo.advertisment.Advertisements
import com.localbitcoins.pojo.advertisment.Advertisment
import com.localbitcoins.pojo.advertisment.AdvertismentsData
import com.localbitcoins.pojo.dashboard.*
import com.localbitcoins.pojo.fees.Fees
import com.localbitcoins.pojo.wallet.Wallet
import org.apache.http.client.utils.URLEncodedUtils
import java.io.IOException
import java.net.URI
import java.net.URISyntaxException
import java.nio.charset.Charset
import java.util.*

class LocalBitcoinsUtils {

    companion object {

        @Throws(IOException::class)
        internal fun getAd(adId: Int?, localBitcoinsKey: String, localBitcoinsSecret: String): Advertisment {
            val parameterCollection = ParameterCollection(ArrayList())
            val request = LocalBitcoinsRequest(
                localBitcoinsKey,
                localBitcoinsSecret,
                "/ad-get/$adId/",
                parameterCollection,
                LocalBitcoinsRequest.HttpType.GET
            )
            val data = request.pullData()

            val advertisements = ObjectMapper().readValue(data, Advertisements::class.java)
            Objects.requireNonNull<AdvertismentsData>(advertisements.advertismentsData)
            Objects.requireNonNull<List<Advertisment>>(advertisements.advertismentsData!!.advertisment)
            return advertisements.advertismentsData!!.advertisment!![0]
        }

        @Throws(IOException::class)
        fun getTransaction(transactionId: String, localBitcoinsKey: String, localBitcoinsSecret: String): ContactData {
            val parameterCollection = ParameterCollection(ArrayList())
            val request = LocalBitcoinsRequest(
                localBitcoinsKey,
                localBitcoinsSecret,
                "/contact_info/$transactionId/",
                parameterCollection,
                LocalBitcoinsRequest.HttpType.GET
            )
            val data = request.pullData()

            val transaction = ObjectMapper().readValue(data, Contact::class.java)
            return transaction.data
        }

        @Throws(IOException::class, URISyntaxException::class)
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
                    LocalBitcoinsRequest.CLOSED,
                    parameterCollection,
                    LocalBitcoinsRequest.HttpType.GET
                )
                val data = request.pullData()

                val objectMapper = ObjectMapper()
                val localBitcoinsDashboard = objectMapper.readValue(data, LocalBitcoinsDashboard::class.java)
                val dashboardData = Objects.requireNonNull<DashboardData>(localBitcoinsDashboard.data)
                Objects.requireNonNull<List<Contact>>(dashboardData.contact)
                for (contact in dashboardData.contact!!) {
                    if (contact.data.releasedAt != null && contact.data.isSelling!!) {
                        if (contact.data.contactId == Integer.parseInt(transactionId)) {
                            // Reverse the transaction list to get them from oldest to newest
                            contacts.reverse()
                            return contacts
                        }
                        contacts.add(contact)
                        println(contact.data.releasedAt)
                    }
                }
                Objects.requireNonNull<Pagination>(localBitcoinsDashboard.pagination)
                val nextUrl = localBitcoinsDashboard.pagination!!.next
                Objects.requireNonNull<String>(nextUrl)
                parameterCollection =
                    ParameterCollection(URLEncodedUtils.parse(URI(nextUrl!!), Charset.forName("UTF-8")))
            }
        }

        @Throws(IOException::class)
        fun getWallet(localBitcoinsKey: String, localBitcoinsSecret: String): Wallet {
            val parameterCollection = ParameterCollection(ArrayList())
            val request = LocalBitcoinsRequest(
                localBitcoinsKey,
                localBitcoinsSecret,
                LocalBitcoinsRequest.WALLET,
                parameterCollection,
                LocalBitcoinsRequest.HttpType.GET
            )
            val data = request.pullData()
            return ObjectMapper().readValue(data, Wallet::class.java)
        }

        @Throws(IOException::class)
        fun getFees(localBitcoinsKey: String, localBitcoinsSecret: String): Fees {
            val parameterCollection = ParameterCollection(ArrayList())
            val request = LocalBitcoinsRequest(
                localBitcoinsKey,
                localBitcoinsSecret,
                LocalBitcoinsRequest.FEES,
                parameterCollection,
                LocalBitcoinsRequest.HttpType.GET
            )
            val data = request.pullData()
            return ObjectMapper().readValue(data, Fees::class.java)
        }
    }
}
