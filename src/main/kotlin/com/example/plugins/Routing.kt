package com.example.plugins

import com.example.route.loginRoute
import com.example.route.onePlaceRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        loginRoute()
        onePlaceRoute()
    }
}
