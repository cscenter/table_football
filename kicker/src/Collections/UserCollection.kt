package com.kicker.Collections

import com.kicker.Enteties.User
import com.kicker.kodein
import com.mongodb.client.MongoDatabase
import org.kodein.di.generic.instance
import org.litote.kmongo.*

class UserCollection : Collection<User>() {
    private val database: MongoDatabase by kodein.instance()
    override val collection = database.getCollection<User>()

    fun getByName(name: String): User? {
        return collection.findOne("{nickName:'${name}'}")
    }
}

