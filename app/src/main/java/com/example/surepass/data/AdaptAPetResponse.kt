package com.example.surepass.data

data class AdoptAPetResponse(
    val count: Int,
    val entries: List<AdoptAPetEntry>
)

data class AdoptAPetEntry(
    val API: String,
    val Description: String,
    val Auth: String,
    val HTTPS: Boolean,
    val Cors: String,
    val Link: String,
    val Category: String
)
