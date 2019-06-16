package com.kicker.Enteties

data class User(
    val nickName: String
    , val password: String
) : Entity()

data class Users(val items: List<User>)