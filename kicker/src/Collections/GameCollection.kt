package com.kicker.Collections

import com.kicker.Game
import com.kicker.dbEnteties.Entity
import kotlinx.coroutines.runBlocking
import org.litote.kmongo.coroutine.CoroutineDatabase

class GameCollection: Collection<Game> {
    val database: CoroutineDatabase? = null
    val collection = database?.getCollection<Game>()

    override fun add(record: Game): Game {
        runBlocking {
            collection?.insertOne(record)
        }
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