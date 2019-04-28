package com.kicker.Services

import com.kicker.Collections.GameCollection
import com.kicker.Enteties.Game
import com.kicker.kodein
import org.kodein.di.generic.instance
import java.time.LocalDateTime


class GameService {
    private val gameCollection: GameCollection by kodein.instance()

    fun create(): String? {
        val game = Game(creationTime = LocalDateTime.now())
        gameCollection.add(game)
        return game._id
    }

    fun end(gameId: String) {
        gameCollection.updateEndTimeById(gameId, LocalDateTime.now())

    }

    fun start(gameId: String) {
        gameCollection.updateStartTimeById(gameId, LocalDateTime.now())
    }

    fun addUserToRedTeam(userName: String, gameId: String) {
        gameCollection.addUserToRed(userName, gameId)
    }

    fun addUserToBlueTeam(userName: String, gameId: String) {
        gameCollection.addUserToBlue(userName, gameId)
    }
}