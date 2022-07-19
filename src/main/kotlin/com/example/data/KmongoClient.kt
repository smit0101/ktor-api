package com.example.data

import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val userName = System.getenv("userName")
val password = System.getenv("password")
val client = KMongo.createClient("mongodb+srv://$userName:$password@cluster0.p0poyu3.mongodb.net/test").coroutine
val userDb = client.getDatabase("USERS")

inline fun <reified T:Any> getCollection() = userDb.getCollection<T>()