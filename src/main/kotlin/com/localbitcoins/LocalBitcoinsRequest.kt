package com.localbitcoins

import com.fasterxml.jackson.databind.ObjectMapper
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.content.TextContent
import java.net.URLEncoder


object LocalBitcoinsRequest {

    private val client = HttpClient()

    private fun generateSignature(
        localBitcoinsKey: String,
        localBitcoinsSecret: String,
        path: String,
        parametersString: String,
        nonce: String
    ): String =
        HMACSignature.calculate(
            localBitcoinsKey,
            localBitcoinsSecret,
            path,
            parametersString,
            nonce
        )

    suspend fun get(
        localBitcoinsKey: String,
        localBitcoinsSecret: String,
        path: String,
        parameters: Map<String, String>?,
        type: HttpType
    ): String {

        val parametersString = parameters?.map { p ->
            URLEncoder.encode(p.key, "UTF-8") + "=" + URLEncoder.encode(p.value, "UTF-8")
        }?.reduce { p1, p2 ->
            "$p1&$p2"
        } ?: ""

        val nonce = (System.currentTimeMillis() * 1000).toString()
        val signature = generateSignature(
            localBitcoinsKey,
            localBitcoinsSecret,
            path.substringAfter(BASE_URL).replace("?", ""),
            parametersString,
            nonce
        )

        try {
            return when (type) {
                HttpType.GET -> client.get(path + if (parametersString.isEmpty()) "" else "?$parametersString") {
                    header("Apiauth-Key", localBitcoinsKey)
                    header("Apiauth-Nonce", nonce)
                    header("Apiauth-Signature", signature)
                }
                HttpType.POST -> client.post(path) {
                    header("Apiauth-Key", localBitcoinsKey)
                    header("Apiauth-Nonce", nonce)
                    header("Apiauth-Signature", signature)
                    body = TextContent(
                        ObjectMapper().writeValueAsString(parameters),
                        contentType = ContentType.Application.Json
                    )
                }
            }
        } catch (t: Throwable) {
            throw LocalbitcoinsAPIException("${t.message} " + path + " " + parametersString)
        }
    }

    suspend fun getBinary(
        localBitcoinsKey: String,
        localBitcoinsSecret: String,
        path: String
    ): ByteArray {
        val nonce = (System.currentTimeMillis() * 1000).toString()
        val signature = generateSignature(
            localBitcoinsKey,
            localBitcoinsSecret,
            path.substringAfter(BASE_URL).replace("?", ""),
            "",
            nonce
        )

        return try {
            client.get(path) {
                header("Apiauth-Key", localBitcoinsKey)
                header("Apiauth-Nonce", nonce)
                header("Apiauth-Signature", signature)
            }
        } catch (t: Throwable) {
            throw LocalbitcoinsAPIException("${t.message} " + path)
        }
    }

    enum class HttpType {
        GET, POST
    }

    private const val BASE_URL = "https://localbitcoins.com"
    private const val API_BASE_URL = "$BASE_URL/api"

    const val WALLET = "$API_BASE_URL/wallet/"
    const val WALLET_BALANCE = "$API_BASE_URL/wallet-balance/"
    const val WALLET_SEND = "$API_BASE_URL/wallet-send/"
    const val DASHBOARD = "$API_BASE_URL/dashboard/"
    const val RELEASED = DASHBOARD + "released/"
    const val CANCELED = DASHBOARD + "canceled/"
    const val CLOSED = DASHBOARD + "closed/"
    const val FEES = "$API_BASE_URL/fees/"
    const val MYSELF = "$API_BASE_URL/myself/"
    const val ACCOUNT_INFO = "$API_BASE_URL/account_info/"
    const val CONTACT_RELEASE = "$API_BASE_URL/contact_release/"
    const val AD_GET = "$API_BASE_URL/ad-get/"
    const val CONTACT_INFO = "$API_BASE_URL/contact_info/"
    const val CONTACT_MESSAGES = "$API_BASE_URL/contact_messages/"
    const val CONTACT_MESSAGE_POST = "$API_BASE_URL/contact_message_post/"
}
