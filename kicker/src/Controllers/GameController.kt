package com.kicker.Controllers

import com.kicker.Collections.GameCollection
import com.kicker.Enteties.Game
import com.kicker.Enteties.Games
import com.kicker.Services.GameService
import com.kicker.kodein
import io.ktor.application.call
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.authentication
import io.ktor.response.header
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import org.kodein.di.generic.instance


private const val GAME_START_ENDPOINT = "/api/startGame"
private const val GAME_END_ENDPOINT = "/api/endGame"
private const val GAME_CREATE_ENDPOINT = "/api/createGame"
private const val ALL_GAMES = "/api/allGames"
private const val JOIN_RED = "/api/joinRed"
private const val JOIN_BLUE = "/api/joinBlue"


class GameController {
    val gameCollection: GameCollection by kodein.instance()
    fun getAllGames(): List<Game> {
        val games = gameCollection.getAll()
        return games
    }
}

fun Route.gameController() {
    val gameService: GameService by kodein.instance()
    val gameController: GameController by kodein.instance()
    get(ALL_GAMES) {
        val games = gameController.getAllGames()
        call.response.header("Access-Control-Allow-Origin", "*")
        call.respond(mapOf("data" to Games(games)))
    }

    post(GAME_CREATE_ENDPOINT) {
        val gameId = gameService.create()
        if (gameId != null) {
            call.response.header("Access-Control-Allow-Origin", "*")
            call.respond(mapOf("id" to gameId))
        }
        throw RuntimeException("Unable to create game")
    }

    get(GAME_START_ENDPOINT) {
        gameService.start(call.request.queryParameters["_id"]!!)
        call.respondText("Game started")
    }

    post(GAME_END_ENDPOINT) {
        gameService.end(call.request.queryParameters["_id"]!!)
        call.respondText("Game ended")
    }

    post(JOIN_RED) {
        call.response.header("Access-Control-Allow-Origin", "*")
        val userName = call.request.queryParameters["userName"]!!
        val gameId = call.request.queryParameters["gameId"]!!
        gameService.addUserToRedTeam(userName, gameId)
        call.respond(mapOf("userName" to "test"))
    }

    post(JOIN_BLUE) {
        call.response.header("Access-Control-Allow-Origin", "*")
        val userName = call.request.queryParameters["userName"]!!
        val gameId = call.request.queryParameters["gameId"]!!
        gameService.addUserToBlueTeam(userName, gameId)
        call.respond(mapOf("userName" to "test"))
    }
}

