package com.kicker.Collections

import com.kicker.Enteties.User
import com.kicker.kodein
import com.mongodb.client.MongoDatabase
import org.kodein.di.generic.instance
import org.litote.kmongo.*

class UserCollection : Collection<User> {
    private val database: MongoDatabase by kodein.instance()
    private val collection = database.getCollection<User>()

    override fun add(record: User): String? {
        collection.insertOne(record)
        return record._id
    }

    override fun getAll(): List<User> {
        val users = mutableListOf<User>()
        collection.find("{}").into(users)
        return users
    }

    override fun getById(id: String): User? {
        val user = collection.findOne("{_id:'${id}'}")
        return user
    }

    override fun getByName(name: String): User? {
        val user = collection.findOne("{nickName:'${name}'}")
        return user
    }


    override fun remove(id: String) {
        collection.deleteOne("{_id:'${id}'}")
    }

    override fun clear() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

