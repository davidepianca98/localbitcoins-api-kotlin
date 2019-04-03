package com.localbitcoins.pojo.dashboard

import com.fasterxml.jackson.annotation.*
import java.io.Serializable
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("message_post_url", "advertisement_url", "messages_url", "release_url", "advertisement_public_view")
class Actions : Serializable {

    @JsonProperty("message_post_url")
    @get:JsonProperty("message_post_url")
    @set:JsonProperty("message_post_url")
    var messagePostUrl: String? = null
    @JsonProperty("advertisement_url")
    @get:JsonProperty("advertisement_url")
    @set:JsonProperty("advertisement_url")
    var advertisementUrl: String? = null
    @JsonProperty("messages_url")
    @get:JsonProperty("messages_url")
    @set:JsonProperty("messages_url")
    var messagesUrl: String? = null
    @JsonProperty("release_url")
    @get:JsonProperty("release_url")
    @set:JsonProperty("release_url")
    var releaseUrl: String? = null
    @JsonProperty("advertisement_public_view")
    @get:JsonProperty("advertisement_public_view")
    @set:JsonProperty("advertisement_public_view")
    var advertisementPublicView: String? = null
    @JsonIgnore
    private val additionalProperties = HashMap<String, Any?>()

    @JsonAnyGetter
    fun getAdditionalProperties(): Map<String, Any?> {
        return this.additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any?) {
        this.additionalProperties[name] = value
    }

    override fun toString(): String {
        return "Actions(messagePostUrl=$messagePostUrl," +
                "advertisementUrl=$advertisementUrl," +
                "messagesUrl=$messagesUrl," +
                "releaseUrl=$releaseUrl," +
                "advertisementPublicView=$advertisementPublicView," +
                "additionalProperties=$additionalProperties)"
    }

}
