package com.kicker.Collections

import com.kicker.User
import com.kicker.dbEnteties.Entity
import kotlinx.coroutines.runBlocking
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.newId

class UserCollection: Collection<User> {
    val database: CoroutineDatabase? = null
    val collection = database?.getCollection<User>()

    override fun add(record: User): User {
        runBlocking {
            collection?.insertOne(record)
        }
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