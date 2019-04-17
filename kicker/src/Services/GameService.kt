package com.kicker.Services

import com.kicker.Collections.GameCollection
import com.kicker.Enteties.Game


class GameService {
    val gameCollection: GameCollection? = null

    fun create() {
//        val game = Game()
//        //how to get generated id
//        gameCollection?.add(game)

    }

    fun end(gameId: Int) {
        val game = gameCollection?.get(gameId)
    }

    fun stats(gameId: Int) {}
}