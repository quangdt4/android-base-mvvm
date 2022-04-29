package com.example.inspired.data.network.response

data class Location(
    val city: String,
    val country: String,
    val name: String,
    val position: Position
)

data class Position(
    val latitude: Double,
    val longitude: Double
)