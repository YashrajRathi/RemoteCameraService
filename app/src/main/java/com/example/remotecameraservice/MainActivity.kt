package com.example.remotecameraservice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.remotecameraservice.ui.theme.RemoteCameraServiceTheme
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RemoteCameraServiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Yashraj",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // State to track if the button has been clicked
    var isClicked by remember { mutableStateOf(false) }

    Button(
        onClick = { isClicked = !isClicked },  // Toggle the click state on button press
        modifier = modifier
    ) {
        // Conditional text based on whether the button has been clicked
        Text(if (isClicked) {
            "Hello, $name!"
        } else {
            "Click me!"
        }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RemoteCameraServiceTheme {
        Greeting("Android")
    }
}