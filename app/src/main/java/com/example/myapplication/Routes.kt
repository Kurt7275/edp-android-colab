package com.example.myapplication

import kotlinx.serialization.Serializable

// Home screen has no data — use a singleton object
@Serializable
object Home

// Greeting screen carries the user's name — use a data class
@Serializable
data class Greeting(val userName: String)
