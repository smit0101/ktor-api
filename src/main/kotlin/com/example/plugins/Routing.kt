package com.example.plugins

import com.example.route.loginRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        loginRoute()
    }
}
