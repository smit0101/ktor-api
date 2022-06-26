package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Person(val id:Int, val name:String, val cars:List<String>)
