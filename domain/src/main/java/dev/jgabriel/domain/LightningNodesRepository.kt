package dev.jgabriel.domain

import dev.jgabriel.domain.model.NodesItem

interface LightningNodesRepository {
    suspend fun getNodes(): List<NodesItem>
}