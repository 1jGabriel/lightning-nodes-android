package dev.jgabriel.presentation.nodeslist

import dev.jgabriel.domain.model.NodesItem

data class NodesListState(
    val isLoading: Boolean = true,
    val nodesList: List<NodesItem> = emptyList(),
    val showError: Boolean = false,
) {
    fun showLoading() =
        NodesListState(
            isLoading = true, showError = false, nodesList = emptyList()
        )

    fun showError() =
        NodesListState(
            isLoading = false, showError = true, nodesList = emptyList()
        )

    fun showList(nodesList: List<NodesItem>) = NodesListState(
        isLoading = false,
        showError = false,
        nodesList = nodesList
    )
}