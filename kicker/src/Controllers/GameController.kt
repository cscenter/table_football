package com.kicker.Controllers

import com.kicker.Services.GameService
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty


const val GAME_START_ENDPOINT = "/game/start"
const val GAME_END_ENDPOINT = "/game/end"
const val STATS_ENDPOINT = "/game/stats"


class GameController {
    val gameService: GameService? = null

    fun startServer() {
        val server = embeddedServer(Netty, port = 8080) {
            routing {
                get(GAME_START_ENDPOINT) {
                    gameService?.create()
                }

            }
        }
        server.start(wait = true)
    }
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