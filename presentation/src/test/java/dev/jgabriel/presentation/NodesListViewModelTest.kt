package dev.jgabriel.presentation

import dev.jgabriel.domain.LightningNodesRepository
import dev.jgabriel.domain.model.NodesItem
import dev.jgabriel.presentation.nodeslist.NodesListState
import dev.jgabriel.presentation.nodeslist.NodesListViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class NodesListViewModelTest {
    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()
    private val fakeRepo = FakeRepository()
    lateinit var vm: NodesListViewModel
    private val emissions = mutableListOf<NodesListState>()

    @Before
    fun setup() {
        vm = NodesListViewModel(fakeRepo)
    }

    @Test
    fun `WHEN started THEN set correct state`() =
        runTest {
            val expected = NodesListState()

            val actual = vm.state.value

            assertEquals(expected, actual)
        }

    @Test
    fun `WHEN call node THEN state must be showList`() {
        runTest {
            val initialState = NodesListState()
            val showListState = NodesListState(
                isLoading = false,
                showError = false,
                nodesList = listOf(
                    NodesItem(
                        alias = "usu",
                        capacity = "Caloosahatchee",
                        channels = 6320,
                        city = null,
                        country = null,
                        firstSeen = "parturient",
                        publicKey = "minim",
                        updatedAt = "pertinax"
                    )
                )
            )
            val job =
                launch(coroutinesTestRule.dispatcher) { vm.state.toList(destination = emissions) }
            vm.getLightningNodes()

            assertEquals(initialState, emissions[0])
            assertEquals(showListState, emissions[1])
            job.cancel()
        }
    }

    @Test
    fun `WHEN call node THEN state must be error`() {
        runTest {
            val initialState = NodesListState()
            val errorState = NodesListState(
                isLoading = false,
                showError = true,
                nodesList = listOf()
            )
            fakeRepo.showError = true
            val job =
                launch(coroutinesTestRule.dispatcher) { vm.state.toList(destination = emissions) }
            vm.getLightningNodes()

            assertEquals(initialState, emissions[0])
            assertEquals(errorState, emissions[1])
            job.cancel()
        }
    }
}

class FakeRepository : LightningNodesRepository {
    var showError = false
    override suspend fun getNodes(): List<NodesItem> {
        if (showError) {
            throw Exception()
        } else {
            return listOf(
                NodesItem(
                    alias = "usu",
                    capacity = "Caloosahatchee",
                    channels = 6320,
                    city = null,
                    country = null,
                    firstSeen = "parturient",
                    publicKey = "minim",
                    updatedAt = "pertinax"
                )
            )
        }
    }
}