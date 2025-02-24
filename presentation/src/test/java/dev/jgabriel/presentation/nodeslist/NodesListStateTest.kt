package dev.jgabriel.presentation.nodeslist

import dev.jgabriel.domain.model.NodesItem
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class NodesListStateTest {
    @Test
    fun `when call showLoading THEN state loading must be true`() {
        val expected = NodesListState(isLoading = true, showError = false, nodesList = emptyList())
        val given = NodesListState().showLoading()
        assertEquals(expected, given)
    }

    @Test
    fun `when call showError THEN state error must be true`() {
        val given = NodesListState(isLoading = false, showError = true, nodesList = emptyList())
        val expected = NodesListState().showError()
        assertEquals(expected, given)
    }

    @Test
    fun `when call showList THEN state must be the same list`() {
        val fakeList = listOf(
            NodesItem(
                alias = "saepe",
                capacity = "Smeaton",
                channels = 7623,
                city = null,
                country = null,
                firstSeen = "amet",
                publicKey = "consetetur",
                updatedAt = "efficiantur"
            )
        )
        val given = NodesListState(
            isLoading = false, showError = false, nodesList = fakeList
        )
        val expected = NodesListState().showList(fakeList)
        assertEquals(expected, given)
    }

}