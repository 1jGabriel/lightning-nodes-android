package dev.jgabriel.lightningnodes.data.response

import com.google.gson.annotations.SerializedName
import dev.jgabriel.domain.model.NodesItem

data class NodesItemResponse(
    @SerializedName("alias")
    val alias: String,
    @SerializedName("capacity")
    val capacity: Long,
    @SerializedName("channels")
    val channels: Int,
    @SerializedName("city")
    val city: CityResponse,
    @SerializedName("country")
    val country: CountryResponse,
    @SerializedName("firstSeen")
    val firstSeen: Int,
    @SerializedName("publicKey")
    val publicKey: String,
    @SerializedName("updatedAt")
    val updatedAt: Int
)

fun NodesItemResponse.toDomain() = NodesItem(
    alias = alias,
    capacity = capacity,
    channels = channels,
    city = city.toDomain(),
    country = country.toDomain(),
    firstSeen = firstSeen,
    publicKey = publicKey,
    updatedAt = updatedAt
)