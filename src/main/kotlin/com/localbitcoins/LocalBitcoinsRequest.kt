package com.localbitcoins

import io.ktor.client.HttpClient
import io.ktor.client.features.ResponseException
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.response.readText
import io.ktor.http.ContentType
import io.ktor.http.content.TextContent
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.apache.commons.codec.binary.Hex
import java.net.URLEncoder
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec


object LocalBitcoinsRequest {

    private val client = HttpClient()
    private val mutex = Mutex()

    private const val METHOD = "HmacSHA256"
    private const val CHARSET = "UTF-8"

    private fun generateNonce(): String = (System.currentTimeMillis() * 1000).toString()

    private fun generateSignature(
        localBitcoinsKey: String,
        localBitcoinsSecret: String,
        path: String,
        parametersString: String,
        nonce: String
    ): String {
        val message = nonce + localBitcoinsKey + path + parametersString
        val sha256HMAC = Mac.getInstance(METHOD)
        val secretKey = SecretKeySpec(localBitcoinsSecret.toByteArray(charset(CHARSET)), METHOD)
        sha256HMAC.init(secretKey)
        val data = sha256HMAC.doFinal(message.toByteArray(charset(CHARSET)))
        return Hex.encodeHexString(data).toUpperCase()
    }

    private fun Map<String, String>.toUrlParameters(): String {
        return map { p ->
            URLEncoder.encode(p.key, "UTF-8") + "=" + URLEncoder.encode(p.value, "UTF-8")
        }.reduce { p1, p2 ->
            "$p1&$p2"
        }
    }

    suspend fun get(
        localBitcoinsKey: String,
        localBitcoinsSecret: String,
        path: String,
        parameters: Map<String, String>?,
        type: HttpType
    ): String {
        val parametersString = parameters?.toUrlParameters()
        return getWithStringParameters(localBitcoinsKey, localBitcoinsSecret, path, parametersString, type)
    }

    suspend fun getWithStringParameters(
        localBitcoinsKey: String,
        localBitcoinsSecret: String,
        path: String,
        parametersString: String?,
        type: HttpType
    ): String {
        val parameters = parametersString ?: ""
        mutex.withLock {
            val nonce = generateNonce()
            val signature = generateSignature(
                localBitcoinsKey,
                localBitcoinsSecret,
                path.substringAfter(BASE_URL),
                parameters,
                nonce
            )

            try {
                return when (type) {
                    HttpType.GET -> client.get(path + if (parameters.isEmpty()) "" else "?$parameters") {
                        header("Apiauth-Key", localBitcoinsKey)
                        header("Apiauth-Nonce", nonce)
                        header("Apiauth-Signature", signature)
                    }
                    HttpType.POST -> client.post(path) {
                        header("Apiauth-Key", localBitcoinsKey)
                        header("Apiauth-Nonce", nonce)
                        header("Apiauth-Signature", signature)
                        body = TextContent(parameters, contentType = ContentType.Application.FormUrlEncoded)
                    }
                }
            } catch (t: Throwable) {
                when (t) {
                    is CancellationException -> throw t
                    is ResponseException -> throw LocalbitcoinsAPIException(
                        "${t.message} " + path + " " + parametersString + " " + t.response.readText(),
                        t
                    )
                    else -> throw LocalbitcoinsAPIException("${t.message} " + path + " " + parametersString, t)
                }
            }
        }
    }

    suspend fun getBinary(
        localBitcoinsKey: String,
        localBitcoinsSecret: String,
        path: String
    ): ByteArray {
        mutex.withLock {
            val nonce = generateNonce()
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
                when (t) {
                    is CancellationException -> throw t
                    is ResponseException -> throw LocalbitcoinsAPIException(
                        "${t.message} " + path + " " + t.response.readText(),
                        t
                    )
                    else -> throw LocalbitcoinsAPIException("${t.message} " + path, t)
                }
            }
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
