package com.kicker.Controllers

import com.kicker.Services.GameService
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get


const val GAME_START_ENDPOINT = "/game/start"
const val GAME_END_ENDPOINT = "/game/end"
const val STATS_ENDPOINT = "/game/stats"


class GameController {
    val gameService: GameService? = null
}

fun Route.gameController() {
    get(GAME_START_ENDPOINT) {
        call.respondText("start game")
    }
    get(GAME_END_ENDPOINT) {
        call.respondText("end game")
    }
    get(STATS_ENDPOINT) {
        call.respondText("game stats")
    }
}