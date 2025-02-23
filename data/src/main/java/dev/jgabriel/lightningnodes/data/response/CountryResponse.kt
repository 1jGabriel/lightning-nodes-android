package dev.jgabriel.lightningnodes.data.response

import com.google.gson.annotations.SerializedName
import dev.jgabriel.domain.model.Country

data class CountryResponse(
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
    val ru: String?,
    @SerializedName("zh-CN")
    val zhCN: String?
)

fun CountryResponse?.toDomain() = this?.let {
    Country(
        de = de,
        en = en,
        es = es,
        fr = fr,
        ja = ja,
        ptBR = ptBR,
        ru = ru,
        zhCN = zhCN
    )
}