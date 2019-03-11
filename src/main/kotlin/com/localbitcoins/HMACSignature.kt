package com.localbitcoins

import org.apache.commons.codec.binary.Hex
import java.io.UnsupportedEncodingException
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

class HMACSignature internal constructor(
    localBitcoinsKey: String,
    private val localBitcoinsSecret: String,
    path: String,
    parameters: String,
    nonce: String
) {

    private val message: String = nonce + localBitcoinsKey + path + parameters

    /**
     * Creates a HMACSHA1 key.
     *
     * @return the created HMAC signature.
     */
    override fun toString(): String {
        try {
            val sha256HMAC = Mac.getInstance(METHOD)
            val secretKey = SecretKeySpec(localBitcoinsSecret.toByteArray(charset(CHARSET)), METHOD)
            sha256HMAC.init(secretKey)
            return Hex.encodeHexString(sha256HMAC.doFinal(message.toByteArray(charset(CHARSET)))).toUpperCase()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        } catch (e: InvalidKeyException) {
            e.printStackTrace()
        }

        return ""
    }

    companion object {

        private const val METHOD = "HmacSHA256"
        private const val CHARSET = "UTF-8"
    }

}