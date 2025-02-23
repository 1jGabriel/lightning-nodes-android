package dev.jgabriel.design.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import dev.jgabriel.design.R
import dev.jgabriel.design.theme.LightningNodesTheme

@Composable
fun LightningCard(
    alias: String,
    capacity: String,
    channels: String,
    location: String,
    publicKey: String,
    firstSeen: String,
    updatedAt: String,
    isExpanded: Boolean = false,
) {
    var expanded by rememberSaveable { mutableStateOf(isExpanded) }

    Card(
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                expanded = !expanded
            }
            .fillMaxWidth(),
        shape = ShapeDefaults.Medium,
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = alias,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Crossfade(
                targetState = expanded,
            ) {
                Image(
                    imageVector = if (it) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.primary),
                    contentDescription = null,
                )
            }
        }
        AnimatedVisibility(
            enter = expandVertically(),
            exit = shrinkVertically(),
            visible = expanded,
        ) {
            Column {


                Text(
                    modifier = Modifier.padding(
                        vertical = 4.dp,
                        horizontal = 8.dp
                    ),
                    text = capacity,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    modifier = Modifier.padding(
                        vertical = 4.dp,
                        horizontal = 8.dp
                    ),
                    text = location,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    modifier = Modifier.padding(
                        vertical = 4.dp,
                        horizontal = 8.dp
                    ),
                    text = stringResource(R.string.lightning_nodes_channels) + channels,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    modifier = Modifier.padding(
                        vertical = 4.dp,
                        horizontal = 8.dp
                    ),
                    text = publicKey,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    modifier = Modifier.padding(
                        vertical = 4.dp,
                        horizontal = 8.dp
                    ),
                    text = stringResource(R.string.lightning_nodes_first_seen) + firstSeen,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    modifier = Modifier.padding(
                        vertical = 4.dp,
                        horizontal = 8.dp
                    ),
                    text = stringResource(R.string.lightning_nodes_updated_at) + updatedAt,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
fun LightningCardPreview() {
    LightningNodesTheme {
        LightningCard(
            alias = "ACINQ",
            capacity = "5584.0092912 BTC",
            channels = "2377",
            location = "Nova York, EUA",
            publicKey = "12-0234i12094u1nfas-0i341298301",
            firstSeen = "02/01/2019 16:13",
            updatedAt = "23/02/2025 20:07"
        )
    }
}

@Preview
@Composable
fun LightningCardExpandedPreview() {
    LightningNodesTheme {
        LightningCard(
            alias = "ACINQ",
            capacity = "5584.0092912 BTC",
            channels = "2377",
            location = "Nova York, EUA",
            publicKey = "12-0234i12094u1nfas-0i341298301",
            firstSeen = "02/01/2019 16:13",
            updatedAt = "23/02/2025 20:07",
            isExpanded = true
        )
    }
}