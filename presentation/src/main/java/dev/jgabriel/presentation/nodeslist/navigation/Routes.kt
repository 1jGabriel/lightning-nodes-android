package dev.jgabriel.presentation.nodeslist.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.jgabriel.presentation.nodeslist.NodesListScreen

fun NavGraphBuilder.nodesList() = composable<NodesListRoute.ListScreen> {
    NodesListScreen()
}