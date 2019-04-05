package com.kicker

import com.kicker.dbEnteties.Entity
import org.litote.kmongo.Id

data class User(val _id: Id<User>, val nickName: String): Entity {
    var rating: Long = 0;
}