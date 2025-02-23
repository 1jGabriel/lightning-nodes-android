package dev.jgabriel.lightningnodes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.jgabriel.design.components.ErrorScreen
import dev.jgabriel.design.components.LightningCard
import dev.jgabriel.design.components.Loading
import dev.jgabriel.design.theme.LightningNodesTheme
import dev.jgabriel.presentation.LightningNodesViewModel
import org.koin.compose.viewmodel.koinViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LightningNodesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = MaterialTheme.colorScheme.background)
                            .padding(innerPadding)
                    ) {
                        val viewModel = koinViewModel<LightningNodesViewModel>()
                        val state by viewModel.state.collectAsStateWithLifecycle()
                        if (state.isLoading) {
                            Loading()
                        }
                        if (state.showError) {
                            ErrorScreen(
                                onClickButton = viewModel::getLightningNodes,
                                title = stringResource(R.string.error_title),
                                description = stringResource(R.string.error_description)
                            )
                        }
                        if (state.nodesList.isNotEmpty()) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        viewModel.getLightningNodes()
                                    }
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text(
                                    modifier = Modifier
                                        .weight(1f),
                                    text = stringResource(R.string.lightning_nodes_title),
                                    style = MaterialTheme.typography.headlineLarge,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                                Image(
                                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                                    imageVector = Icons.Filled.Refresh,
                                    contentDescription = null
                                )
                            }
                            LazyColumn {
                                items(
                                    items = state.nodesList,
                                    key = { it.publicKey }) {
                                    LightningCard(
                                        alias = it.alias,
                                        capacity = it.capacity,
                                        channels = it.channels.toString(),
                                        location = it.getLocation(),
                                        publicKey = it.publicKey,
                                        firstSeen = it.firstSeen,
                                        updatedAt = it.updatedAt
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
