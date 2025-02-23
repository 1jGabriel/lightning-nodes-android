package dev.jgabriel.domain.model

data class NodesItem(
    val alias: String,
    val capacity: String,
    val channels: Int,
    val city: City?,
    val country: Country?,
    val firstSeen: String,
    val publicKey: String,
    val updatedAt: String
) {
    fun getLocation(): String = if (city != null) {
        (city.ptBR ?: city.en) + ", " + getCountry()
    } else {
        getCountry()
    }

    private fun getCountry() = (country?.ptBR ?: country?.en).orEmpty()
}