package com.example.remotecameraservice

import androidx.compose.material3.Text
import io.ktor.http.ContentType
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

fun startServer() {
    runBlocking(Dispatchers.Default) {
        embeddedServer(CIO, port = 8080) {
            routing {
                get("/") {
                    call.respondText("Hello, World!", contentType = ContentType.Text.Plain)
                }
                get("/date") {
                    call.respondText("Current Time: ${java.util.Date()}", contentType = ContentType.Text.Plain)
                }
            }
        }.start(wait = true)
    }
}