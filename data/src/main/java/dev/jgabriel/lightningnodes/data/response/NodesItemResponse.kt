package dev.jgabriel.lightningnodes.data.response

import com.google.gson.annotations.SerializedName
import dev.jgabriel.domain.model.NodesItem
import dev.jgabriel.lightningnodes.data.util.fromSatToBtc
import dev.jgabriel.lightningnodes.data.util.fromUnixToDate

data class NodesItemResponse(
    @SerializedName("alias")
    val alias: String,
    @SerializedName("capacity")
    val capacity: Long,
    @SerializedName("channels")
    val channels: Int,
    @SerializedName("city")
    val city: CityResponse?,
    @SerializedName("country")
    val country: CountryResponse?,
    @SerializedName("firstSeen")
    val firstSeen: Long,
    @SerializedName("publicKey")
    val publicKey: String,
    @SerializedName("updatedAt")
    val updatedAt: Long
)

fun NodesItemResponse.toDomain() = NodesItem(
    alias = alias,
    capacity = "${capacity.fromSatToBtc()} BTC",
    channels = channels,
    city = city?.toDomain(),
    country = country?.toDomain(),
    firstSeen = firstSeen.fromUnixToDate(),
    publicKey = publicKey,
    updatedAt = updatedAt.fromUnixToDate(),
)
