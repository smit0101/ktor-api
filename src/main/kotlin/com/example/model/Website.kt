package com.example.model

import kotlinx.serialization.Serializable
import org.bson.types.ObjectId

@Serializable
data class Website(val id:String = ObjectId().toString(), val title:String="", val url:String="")
