package com.example.model

import kotlinx.serialization.Serializable
import org.bson.types.ObjectId

@Serializable
data class User(val id:String = ObjectId().toString(),
                val firstName:String="null",
                val lastName:String="null",
                val email:String="null",
                val password:String="")