package com.kicker.Enteties

data class User(
    val _id: String? = null
    , val nickName: String
    , val password: String
) : Entity