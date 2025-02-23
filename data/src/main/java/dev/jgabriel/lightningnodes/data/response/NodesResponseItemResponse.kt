package dev.jgabriel.lightningnodes.data.response


import com.google.gson.annotations.SerializedName

data class NodesResponseItemResponse(
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