package com.kicker.Controllers

import com.kicker.Services.GameService
import com.kicker.kodein
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import org.kodein.di.generic.instance


private const val GAME_START_ENDPOINT = "/game/start"
private const val GAME_END_ENDPOINT = "/game/end"
private const val STATS_ENDPOINT = "/game/stats"


class GameController {
}

fun Route.gameController() {
    val gameService: GameService by kodein.instance()
    get(GAME_START_ENDPOINT) {
        val gameIsCreated = gameService.create()
        if (gameIsCreated != null) {
            call.respondText("created game id: $gameIsCreated")
        } else {
            call.respondText("game not created")
        }
    }
    get(GAME_END_ENDPOINT) {
        call.respondText("end game")
    }
    get(STATS_ENDPOINT) {
        call.respondText("game stats")
    }
}

