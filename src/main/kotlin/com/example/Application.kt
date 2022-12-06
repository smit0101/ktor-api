package com.example

import com.example.plugins.configureHTTP
import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import io.ktor.server.cio.*
import io.ktor.server.engine.*

fun main() {
    embeddedServer(CIO, port = 8080, host = "20.175.217.145") {
        configureRouting()
        configureHTTP()
        configureSerialization()
    }.start(wait = true)
}
