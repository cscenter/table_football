package com.kicker.Collections

import com.kicker.Enteties.Entity
import com.mongodb.client.MongoCollection
import org.litote.kmongo.*

abstract class Collection<T : Entity> {

    protected abstract val collection: MongoCollection<T>
    fun add(record: T): String? {
        collection.insertOne(record)
        return record._id
    }

    fun getAll(): List<T> {
        val games = mutableListOf<T>()
        collection.find("{}").into(games)
        return games
    }

    fun getById(id: String): T? {
        return collection.findOne("{_id:'${id}'}")
    }

    fun removeById(id: String) {
        collection.deleteOne("{_id:'${id}'}")
    }
}