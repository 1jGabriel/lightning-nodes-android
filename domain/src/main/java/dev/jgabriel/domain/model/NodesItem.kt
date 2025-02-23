package dev.jgabriel.domain.model

data class NodesItem(
    val alias: String,
    val capacity: Long,
    val channels: Int,
    val city: City,
    val country: Country,
    val firstSeen: Int,
    val publicKey: String,
    val updatedAt: Int
)