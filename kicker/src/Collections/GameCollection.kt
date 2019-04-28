package com.kicker.Collections


import com.kicker.Enteties.Game
import com.kicker.kodein
import com.mongodb.client.MongoDatabase
import org.kodein.di.generic.instance
import org.litote.kmongo.*
import java.time.LocalDateTime


class GameCollection : Collection<Game>() {
    private val database: MongoDatabase by kodein.instance()
    override val collection = database.getCollection<Game>()

    fun updateEndTimeById(id: String, endTime: LocalDateTime) {
        val game = getById(id)
        if (game != null) {
            game.endTime = endTime
            collection.updateOne(Game::_id eq id, game)
        }
    }

    fun updateStartTimeById(id: String, endTime: LocalDateTime) {
        val game = getById(id)
        if (game != null) {
            game.startTime = endTime
            collection.updateOne(Game::_id eq id, game)
        }
    }

    fun addUserToRed(userName: String, gameId: String) {
        val game = getById(gameId)
        if (game != null) {
            game.teamRed.add(userName)
            collection.updateOne(Game::_id eq gameId, game)
        }
    }

    fun addUserToBlue(userName: String, gameId: String) {
        val game = getById(gameId)
        if (game != null) {
            game.teamBlue.add(userName)
            collection.updateOne(Game::_id eq gameId, game)
        }
    }
}