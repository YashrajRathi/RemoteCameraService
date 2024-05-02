package com.example.remotecameraservice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.remotecameraservice.ui.theme.RemoteCameraServiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RemoteCameraServiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ServerControlButton(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ServerControlButton(modifier: Modifier = Modifier) {
    // State to track if the server is running
    var isServerRunning by remember { mutableStateOf(false) }

    Button(
        onClick = {
            isServerRunning = !isServerRunning
            if (isServerRunning) {
                // Start the server on a separate coroutine
                thisStartServer()
            } else {
                // Here you can handle server shutdown logic
            }
        },
        modifier = modifier
    ) {
        Text(if (isServerRunning) "Stop Server" else "Start Server")
    }
}

fun thisStartServer() {
    // Assuming startServer from HttpServer.kt is copied here or accessible
    startServer()
}
