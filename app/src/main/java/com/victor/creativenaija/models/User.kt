package com.victor.creativenaija.models

data class User(
    val id: Int,
    val username: String,
    val firstName: String,
    val lastName: String,
    val password:String,
    val registrationDate: Long
) {
}