package com.kicker.Services

import com.kicker.Collections.GameCollection

class GameService {
    val gameCollection: GameCollection? = null

    fun create() {

    }

    fun end(gameId: Int) {
        val game = gameCollection?.get(gameId);

    }

    fun stats(gameId: Int) {

    }
}