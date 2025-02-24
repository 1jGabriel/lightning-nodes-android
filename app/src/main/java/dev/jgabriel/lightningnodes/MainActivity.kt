package dev.jgabriel.lightningnodes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.jgabriel.design.theme.LightningNodesTheme
import dev.jgabriel.presentation.nodeslist.navigation.NodesListRoute
import dev.jgabriel.presentation.nodeslist.navigation.nodesListGraph

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LightningNodesTheme {
                val navController = rememberNavController()
                Scaffold { innerPadding ->
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = NodesListRoute.Graph
                    ) {
                        nodesListGraph(navController)
                    }
                }
            }
        }
    }
}
