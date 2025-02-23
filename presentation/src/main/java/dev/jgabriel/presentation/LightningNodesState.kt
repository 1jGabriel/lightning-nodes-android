package dev.jgabriel.presentation

import dev.jgabriel.domain.model.NodesItem

data class LightningNodesState(
    val isLoading: Boolean = true,
    val nodesList: List<NodesItem> = emptyList(),
    val showError: Boolean = false,
) {
    fun showLoading() =
        LightningNodesState(
            isLoading = true, showError = false, nodesList = emptyList()
        )

    fun showError() =
        LightningNodesState(
            isLoading = false, showError = true, nodesList = emptyList()
        )

    fun showList(nodesList: List<NodesItem>) = LightningNodesState(
        isLoading = false,
        showError = false,
        nodesList = nodesList
    )
}