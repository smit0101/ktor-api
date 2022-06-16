package com.example.route

import com.example.model.Person
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.personRoute() {
    get("/person") {
         call.respond(Person(1,"Smit", listOf("BMW","AUDI","Supra","NSX")))
    }
    post("/add/person"){
        val person:Person = call.receive()
        call.respond(person)
    }

}
