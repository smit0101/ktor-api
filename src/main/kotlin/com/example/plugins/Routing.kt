package com.example.plugins

import com.example.route.personRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        personRoute()
    }
}
