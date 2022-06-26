package com.example.route

import com.example.model.Person
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.bson.types.ObjectId
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.eq
import org.litote.kmongo.reactivestreams.KMongo

@kotlinx.serialization.Serializable
data class User(val id:String = ObjectId().toString(),val name:String="null")

fun Route.personRoute() {
    val userName = System.getenv("userName")
    val password = System.getenv("password")
    val client = KMongo.createClient("mongodb+srv://$userName:$password@cluster0.p0poyu3.mongodb.net/test").coroutine
    val db = client.getDatabase("USERS")
    val collection = db.getCollection<User>()
    get("/person") {
         call.respond(Person(1,"Smit", listOf("BMW","AUDI","Supra","NSX")))
    }
    post("/add/person"){
        val person:Person = call.receive()
        call.respond(person)
    }
    get ("/user/{name?}"){
          val name = call.parameters["name"] ?:call.respondText("Failed", status = HttpStatusCode.BadRequest)
          val user =  collection.findOne(User::name eq name) ?:return@get call.respondText("Failed", status = HttpStatusCode.BadRequest)
          call.respond(user)
    }
    post("/user"){
        val user:User = call.receive()
        val result = collection.insertOne(user).wasAcknowledged()
        if(result) call.respondText("User Added", status = HttpStatusCode.OK)
        else call.respondText("Failed", status = HttpStatusCode.BadRequest)
    }
}
