package com.kicker

import org.litote.kmongo.Id

data class User(val _id: Id<User>, val nickName: String) {
    var rating: Long? = null;
}