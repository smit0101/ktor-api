package com.example

import com.example.plugins.configureHTTP
import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import io.ktor.server.cio.*
import io.ktor.server.engine.*

fun main() {
    embeddedServer(CIO, port = 8080, host = "127.0.0.1") {
        configureRouting()
        configureHTTP()
        configureSerialization()
    }.start(wait = true)
}
