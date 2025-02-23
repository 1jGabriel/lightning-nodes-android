package dev.jgabriel.design

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.jgabriel.design.components.LightningCardExpandedPreview
import dev.jgabriel.design.theme.LightningNodesTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LightningCardTest {
    @get:Rule
    var composeTestRule: ComposeContentTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            LightningNodesTheme {
                LightningCardExpandedPreview()
            }
        }
    }

    @Test
    fun givenExpandedCard_whenClickOnRoot_thenContentDoesNotExist() {
        with(composeTestRule) {
            onNodeWithText(text = "ACINQ", useUnmergedTree = true).performClick()
            onNodeWithText(text = "5584.0092912 BTC", useUnmergedTree = true).assertDoesNotExist()
            onNodeWithText(text = "ACINQ", useUnmergedTree = true).assertIsDisplayed()
        }
    }

    @Test
    fun givenExpandedCard_whenClickOnRoot_thenContentIsDisplayed() {
        with(composeTestRule) {
            onNodeWithText(text = "ACINQ", useUnmergedTree = true).assertIsDisplayed()
            onNodeWithText(text = "5584.0092912 BTC", useUnmergedTree = true).assertIsDisplayed()
            onNodeWithText(text = "Nova York, EUA", useUnmergedTree = true).assertIsDisplayed()
            onNodeWithText(text = "Canais: 2377", useUnmergedTree = true).assertIsDisplayed()
            onNodeWithText(
                text = "12-0234i12094u1nfas-0i341298301",
                useUnmergedTree = true
            ).assertIsDisplayed()
            onNodeWithText(
                text = "Visto pela primeira vez: 02/01/2019 16:13",
                useUnmergedTree = true
            ).assertIsDisplayed()
            onNodeWithText(
                text = "Última atualização: 23/02/2025 20:07",
                useUnmergedTree = true
            ).assertIsDisplayed()
        }
    }
}