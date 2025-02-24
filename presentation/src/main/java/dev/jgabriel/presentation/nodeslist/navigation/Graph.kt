package dev.jgabriel.presentation.nodeslist.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation

fun NavGraphBuilder.nodesListGraph(navController: NavController) = navigation<NodesListRoute.Graph>(
    startDestination = NodesListRoute.ListScreen
) {
    nodesList()
}
