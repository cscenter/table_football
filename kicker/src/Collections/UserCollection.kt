package com.kicker.Collections

import com.kicker.Enteties.User
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.*

class UserCollection : Collection<User> {

    val database: MongoDatabase? = null
    val collection = database?.getCollection<User>()

    override fun add(record: User): User {
        collection?.insertOne(record)
        return record
    }

    override fun getAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(id: Int): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clear() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}