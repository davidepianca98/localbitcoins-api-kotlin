package com.localbitcoins

import org.apache.http.NameValuePair

class ParameterCollection(private var parameters: MutableList<NameValuePair>?) {

    fun add(requestParameter: NameValuePair) {
        this.parameters!!.add(requestParameter)
    }

    fun addAll(vararg requestParameters: NameValuePair) {
        for (p in requestParameters) {
            add(p)
        }
    }

    fun getParameters(): List<NameValuePair>? {
        return parameters
    }

    fun setParameters(parameters: MutableList<NameValuePair>) {
        this.parameters = parameters
    }
}