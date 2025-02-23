package dev.jgabriel.lightningnodes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.jgabriel.lightningnodes.data.client.provideLightningApi
import dev.jgabriel.lightningnodes.data.client.provideOkHttpClient
import dev.jgabriel.lightningnodes.data.client.provideRetrofit
import dev.jgabriel.lightningnodes.data.repository.LightningNodesRepositoryImpl
import dev.jgabriel.lightningnodes.ui.theme.LightningNodesTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    val repository =
        LightningNodesRepositoryImpl(api = provideLightningApi(provideRetrofit(provideOkHttpClient())))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LightningNodesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val coroutineScope = rememberCoroutineScope()
                    LaunchedEffect(Unit) {
                        coroutineScope.launch {
                            val result = repository.getNodes()
                            println(result)
                        }
                    }

                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LightningNodesTheme {
        Greeting("Android")
    }
}