package dev.jgabriel.lightningnodes.data.repository

import dev.jgabriel.domain.LightningNodesRepository
import dev.jgabriel.domain.model.NodesItem
import dev.jgabriel.lightningnodes.data.api.LightningNodeApi
import dev.jgabriel.lightningnodes.data.response.toDomain
import dev.jgabriel.lightningnodes.data.util.handleApi

class LightningNodesRepositoryImpl(
    private val api: LightningNodeApi,
) : LightningNodesRepository {
    override suspend fun getNodes(): List<NodesItem> = handleApi {
        api.getNodes().map {
            it.toDomain()
        }
    }
}