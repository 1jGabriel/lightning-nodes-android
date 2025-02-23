package dev.jgabriel.design.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LightningCard(
    alias: String,
    capacity: String,
    city: String,
    country: String,
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

    }
}