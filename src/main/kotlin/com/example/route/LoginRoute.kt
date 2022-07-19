package com.example.route

import com.example.data.getCollection
import com.example.model.User
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.litote.kmongo.eq

fun Route.loginRoute(){
    get ("/user/{email?}"){
        val email = call.parameters["email"] ?: return@get call.respondText("failed", status = HttpStatusCode.NotFound)
        val user = getCollection<User>().findOne(User::email eq email) ?: return@get call.respondText("faild", status = HttpStatusCode.NotFound)
        call.respond(user)
    }
    post ("/add/user"){
        val user:User = call.receive()
        val result = getCollection<User>().insertOne(user).wasAcknowledged()
        if(result) call.respond(user) else return@post call.respondText("failed", status = HttpStatusCode.NotFound)
    }
}