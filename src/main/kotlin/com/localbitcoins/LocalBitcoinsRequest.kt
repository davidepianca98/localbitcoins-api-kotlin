package com.localbitcoins

import java.net.URLEncoder
import java.util.concurrent.locks.ReentrantLock


object LocalBitcoinsRequest {

    private val lock = ReentrantLock()

    suspend fun get(
        localBitcoinsKey: String,
        localBitcoinsSecret: String,
        path: String,
        parameters: List<Pair<String, String>>?,
        type: HttpType
    ): String {

        val parametersString = parameters?.map { p ->
            URLEncoder.encode(p.first, "UTF-8") + "=" + URLEncoder.encode(p.second, "UTF-8")
        }?.reduce { p1, p2 ->
            "$p1&$p2"
        } ?: ""

        val nonce = ((System.currentTimeMillis() * 1000) + 2000).toString()
        val signature = HMACSignature.calculate(
            localBitcoinsKey,
            localBitcoinsSecret,
            path.substringAfter("https://localbitcoins.com").replace("?", ""),
            parametersString,
            nonce
        )

        lock.lock()
        return try {
            when (type) {
                HttpType.GET -> Fuel.get(path, parameters)
                    .header("Apiauth-Key", localBitcoinsKey)
                    .header("Apiauth-Nonce", nonce)
                    .header("Apiauth-Signature", signature)
                    .awaitString()
                HttpType.POST -> Fuel.post(path, parameters)
                    .header("Apiauth-Key", localBitcoinsKey)
                    .header("Apiauth-Nonce", nonce)
                    .header("Apiauth-Signature", signature)
                    .awaitString()
            }
        } catch (e: Exception) {
            throw LocalbitcoinsAPIException(e.message + " " + e.cause + " " + path + " " + parametersString)
        } finally {
            lock.unlock()
        }
    }

    enum class HttpType {
        GET, POST
    }

    private const val BASE_URL = "https://localbitcoins.com/api"

    const val WALLET = "$BASE_URL/wallet/"
    const val WALLET_BALANCE = "$BASE_URL/wallet-balance/"
    const val DASHBOARD = "$BASE_URL/dashboard/"
    const val RELEASED = DASHBOARD + "released/"
    const val CANCELED = DASHBOARD + "canceled/"
    const val CLOSED = DASHBOARD + "closed/"
    const val FEES = "$BASE_URL/fees/"
    const val MYSELF = "$BASE_URL/myself/"
    const val ACCOUNT_INFO = "$BASE_URL/account_info/"
    const val CONTACT_RELEASE = "$BASE_URL/contact_release/"
    const val AD_GET = "$BASE_URL/ad-get/"
    const val CONTACT_INFO = "$BASE_URL/contact_info/"
    const val CONTACT_MESSAGES = "$BASE_URL/contact_messages/"
    const val CONTACT_MESSAGE_POST = "$BASE_URL/contact_message_post/"
}