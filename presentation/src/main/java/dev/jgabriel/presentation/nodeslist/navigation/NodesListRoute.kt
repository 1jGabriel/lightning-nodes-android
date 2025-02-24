package dev.jgabriel.presentation.nodeslist.navigation

import kotlinx.serialization.Serializable

sealed interface NodesListRoute {
    @Serializable
    data object Graph : NodesListRoute

    @Serializable
    data object ListScreen : NodesListRoute
}
