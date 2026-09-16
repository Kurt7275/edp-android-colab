package com.liceo.liceochat.data.network.dto

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.longOrNull

@OptIn(kotlinx.serialization.ExperimentalSerializationApi::class)
object FlexibleLongSerializer : KSerializer<Long?> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("FlexibleLong", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Long?) {
        if (value != null) encoder.encodeLong(value) else encoder.encodeNull()
    }

    override fun deserialize(decoder: Decoder): Long? {
        val jsonDecoder = decoder as? JsonDecoder
            ?: return try { decoder.decodeLong() } catch (_: Exception) { null }
        val element = jsonDecoder.decodeJsonElement()
        if (element is JsonPrimitive) {
            element.longOrNull?.let { return it }
            element.contentOrNull?.let { str ->
                str.toLongOrNull()?.let { return it }
                return null
            }
        }
        return null
    }
}

@Serializable
data class MessageDto(
    val id: String? = null,
    val sender: String? = null,
    val text: String? = null,
    @Serializable(with = FlexibleLongSerializer::class)
    val createdAt: Long? = null
)

@Serializable
data class NewMessageDto(                          // GIVEN (read it, do not change it)
    val sender: String,                     // no id here - the server makes it
    val text: String,
    val createdAt: Long
)
