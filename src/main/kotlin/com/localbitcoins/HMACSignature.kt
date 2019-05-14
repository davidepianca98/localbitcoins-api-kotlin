package com.localbitcoins

import org.apache.commons.codec.binary.Hex
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object HMACSignature {

    /**
     * Creates a HMACSHA1 key.
     *
     * @return the created HMAC signature.
     */
    fun calculate(
        localBitcoinsKey: String,
        localBitcoinsSecret: String,
        path: String,
        parameters: String,
        nonce: String
    ): String {
        val message: String = nonce + localBitcoinsKey + path + parameters
        val sha256HMAC = Mac.getInstance(METHOD)
        val secretKey = SecretKeySpec(localBitcoinsSecret.toByteArray(charset(CHARSET)), METHOD)
        sha256HMAC.init(secretKey)
        return Hex.encodeHexString(sha256HMAC.doFinal(message.toByteArray(charset(CHARSET)))).toUpperCase()
    }

    private const val METHOD = "HmacSHA256"
    private const val CHARSET = "UTF-8"
}