package dev.jgabriel.presentation.nodeslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jgabriel.domain.LightningNodesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NodesListViewModel(
    private val lightningNodesRepository: LightningNodesRepository
) : ViewModel() {
    private var _state = MutableStateFlow(NodesListState())
    val state = _state
        .onStart {
            getLightningNodes()
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _state.value
        )

    fun getLightningNodes() {
        viewModelScope.launch {
            _state.update { state ->
                state.showLoading()
            }
            runCatching {
                lightningNodesRepository.getNodes()
            }.onSuccess { result ->
                _state.update { state ->
                    state.showList(result)
                }
            }.onFailure {
                _state.update {
                    it.showError()
                }
            }
        }
    }
}
