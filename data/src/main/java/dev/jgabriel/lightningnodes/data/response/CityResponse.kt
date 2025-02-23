package dev.jgabriel.lightningnodes.data.response

import com.google.gson.annotations.SerializedName
import dev.jgabriel.domain.model.City

data class CityResponse(
    @SerializedName("de")
    val de: String?,
    @SerializedName("en")
    val en: String,
    @SerializedName("es")
    val es: String?,
    @SerializedName("fr")
    val fr: String?,
    @SerializedName("ja")
    val ja: String?,
    @SerializedName("pt-BR")
    val ptBR: String?,
    @SerializedName("ru")
    val ru: String?
)

fun CityResponse.toDomain() = City(
    de = de,
    en = en,
    es = es,
    fr = fr,
    ja = ja,
    ptBR = ptBR,
    ru = ru,
)