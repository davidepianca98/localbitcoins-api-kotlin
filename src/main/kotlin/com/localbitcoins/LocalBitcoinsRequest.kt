package com.localbitcoins

import org.apache.http.HttpResponse
import org.apache.http.NameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.*
import org.apache.http.impl.client.HttpClientBuilder
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

class LocalBitcoinsRequest(
    private val localBitcoinsKey: String,
    private val localBitcoinsSecret: String,
    path: String,
    private val parameters: ParameterCollection,
    private val type: HttpType
) {
    private val path: String = if (path.startsWith("/api")) path else "/api$path"

    private val content: HttpResponse?
        get() {
            Objects.requireNonNull<List<NameValuePair>>(parameters.getParameters())
            val client = HttpClientBuilder.create().build()
            val form = UrlEncodedFormEntity(parameters.getParameters(), "UTF-8")
            val inputStream = BufferedReader(InputStreamReader(form.content))
            var parametersString = inputStream.readLine()
            if (parametersString == null)
                parametersString = ""
            val base: HttpRequestBase
            when (type) {
                HttpType.GET -> base = HttpGet(constructUrl() + "?" + parametersString)
                HttpType.POST -> {
                    base = HttpPost(constructUrl())
                    base.entity = form
                }
                HttpType.DELETE -> base = HttpDelete(constructUrl())
                HttpType.PUT -> base = HttpPut(constructUrl())
            }
            val nonce = (System.currentTimeMillis() * 1000).toString()
            val signature = HMACSignature(localBitcoinsKey, localBitcoinsSecret, this.path, parametersString, nonce).toString()
            base.addHeader("Content-Type", "application/x-www-form-urlencoded")
            base.addHeader("Apiauth-Key", localBitcoinsKey)
            base.addHeader("Apiauth-Nonce", nonce)
            base.addHeader("Apiauth-Signature", signature)
            return client.execute(base)
        }

    enum class HttpType {
        GET, POST, DELETE, PUT
    }

    @Throws(IOException::class)
    fun pullData(): String {
        return BufferedReader(InputStreamReader(content!!.entity.content)).use(BufferedReader::readText)
    }

    private fun constructUrl(): String {
        return BASE_URL + path
    }

    companion object {

        private const val BASE_URL = "https://localbitcoins.com"

        const val WALLET = "/wallet/"
        const val WALLET_BALANCE = "/wallet-balance/"
        const val DASHBOARD = "/dashboard/"
        const val RELEASED = DASHBOARD + "released/"
        const val CANCELED = DASHBOARD + "canceled/"
        const val CLOSED = DASHBOARD + "closed/"
        const val FEES = "/fees/"
    }

}