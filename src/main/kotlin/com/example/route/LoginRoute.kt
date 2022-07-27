package com.example.route

import com.example.data.getCollection
import com.example.data.onePlaceDb
import com.example.model.User
import com.example.model.Website
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


fun Route.onePlaceRoute(){
    get("/websites"){
        val webSiteCollection = onePlaceDb.getCollection<Website>()
        val webSites = webSiteCollection.find().toList() as? MutableList ?: return@get call.respondText("failed", status = HttpStatusCode.NotFound)
        call.respond(webSites)
    }
    post ("/add/websites"){
        val website = call.receive<Website>()
        val result = onePlaceDb.getCollection<Website>().insertOne(website).wasAcknowledged()
        if(result) call.respond(onePlaceDb.getCollection<Website>().find().toList() as? MutableList ?: mutableListOf<Website>()) else return@post call.respondText("failed", status = HttpStatusCode.NotFound)
    }
    delete ("/remove/website/{title?}"){
        val title = call.parameters["title"] ?: return@delete call.respondText("failed", status = HttpStatusCode.NotFound)
        val result = onePlaceDb.getCollection<Website>().deleteOne(Website::title eq title).wasAcknowledged()
        if(result) call.respond(onePlaceDb.getCollection<Website>().find().toList() as? MutableList ?: mutableListOf<Website>()) else return@delete call.respondText("failed", status = HttpStatusCode.NotFound)
    }
}