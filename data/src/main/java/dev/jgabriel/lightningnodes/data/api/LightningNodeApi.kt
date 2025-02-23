package dev.jgabriel.lightningnodes.data.api

import dev.jgabriel.lightningnodes.data.response.NodesItemResponse
import retrofit2.http.GET

internal const val BASE_URL = "https://mempool.space/api/v1/lightning/"

interface LightningNodeApi {
    @GET("nodes/rankings/connectivity")
    suspend fun getNodes(): List<NodesItemResponse>
}
