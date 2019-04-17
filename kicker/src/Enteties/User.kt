package com.kicker.Enteties

import org.litote.kmongo.Id

data class User(val _id: Id<User>?, val nickName: String) : Entity