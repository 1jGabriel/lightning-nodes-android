package dev.jgabriel.design.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.jgabriel.design.R

@Composable
fun LightningCard(
    alias: String,
    capacity: String,
    channels: String,
    location: String,
    publicKey: String,
    firstSeen: String,
    updatedAt: String
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = ShapeDefaults.Medium,
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = alias,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
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