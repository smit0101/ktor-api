package com.example.data

import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo


val client = KMongo.createClient("mongodb+srv://smitnash:9099850857@cluster0.p0poyu3.mongodb.net/test").coroutine
val userDb = client.getDatabase("USERS")
val onePlaceDb = client.getDatabase("ONEPLACE")
fun <T:Any> getDb(dbName:String)= client.getDatabase(dbName)

inline fun <reified T:Any> getCollection() = userDb.getCollection<T>()