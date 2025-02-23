package dev.jgabriel.lightningnodes.data.repository

import dev.jgabriel.lightningnodes.data.api.LightningNodeApi
import dev.jgabriel.lightningnodes.data.util.handleApi

class LightningNodesRepositoryImpl(
    private val api: LightningNodeApi,
) {
    // todo create interface on domain layer
    suspend fun getNodes() = handleApi {
        // todo transform into a domain model
        api.getNodes()
    }
}