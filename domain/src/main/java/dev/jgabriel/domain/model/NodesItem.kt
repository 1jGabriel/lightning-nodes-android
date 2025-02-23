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
)