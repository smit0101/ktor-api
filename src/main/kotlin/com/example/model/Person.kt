package com.example.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.util.*

@Serializable
data class Person(val id:Int, val name:String, val cars:List<String>)