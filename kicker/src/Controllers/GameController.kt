package com.kicker.Controllers

import com.kicker.Services.GameService
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