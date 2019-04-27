package com.kicker.Collections


import com.kicker.Enteties.Game
import org.litote.kmongo.*


class GameCollection : Collection<Game> {

    override fun add(record: Game): String? {
        val client = KMongo.createClient()
        val database = client.getDatabase("test")
        val user_col = database.getCollection<Game>()
        user_col.insertOne(record)
        return record._id
    }

    override fun getAll(): List<Game> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getById(id: String): Game? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getByName(name: String): Game? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(id: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clear() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}