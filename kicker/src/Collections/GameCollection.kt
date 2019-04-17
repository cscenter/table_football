package com.kicker.Collections


import com.kicker.Enteties.Game
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.*


class GameCollection : Collection<Game> {

    val database: MongoDatabase? = null
    val collection = database?.getCollection<Game>()

    override fun add(record: Game): Game {
        collection?.insertOne(record)
        return record
    }

    override fun getAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(id: Int): Game {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clear() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}