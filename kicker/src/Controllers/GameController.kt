package com.kicker.Controllers

import com.kicker.Collections.GameCollection
import com.kicker.Enteties.Game
import com.kicker.Enteties.Games
import com.kicker.Services.GameService
import com.kicker.kodein
import io.ktor.application.call
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.authentication
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import org.kodein.di.generic.instance


private const val GAME_START_ENDPOINT = "/startGame"
private const val GAME_END_ENDPOINT = "/endGame"
private const val GAME_CREATE_ENDPOINT = "/createGame"
private const val ALL_GAMES = "/allGames"
private const val JOIN_RED = "/joinRed"
private const val JOIN_BLUE = "/joinBlue"


class GameController {
    val gameCollection: GameCollection by kodein.instance()
    fun getAllGames(): List<Game> {
        val users = gameCollection.getAll()
        return users
    }
}

fun Route.gameController() {
    val gameService: GameService by kodein.instance()
    val gameController: GameController by kodein.instance()
    get(ALL_GAMES) {
        val games = gameController.getAllGames()
        call.respond(FreeMarkerContent("allGames.ftl", mapOf("data" to Games(games)), ""))
    }

    get(GAME_CREATE_ENDPOINT) {
        val gameIsCreated = gameService.create()
        if (gameIsCreated != null) {
            call.respondText("created game id: $gameIsCreated")
        } else {
            call.respondText("game not created")
        }
    }

    get(GAME_START_ENDPOINT) {
        gameService.start(call.request.queryParameters["_id"]!!)
        call.respondText("Game started")
    }

    get(GAME_END_ENDPOINT) {
        gameService.end(call.request.queryParameters["_id"]!!)
        call.respondText("Game ended")
    }

    get(JOIN_RED) {
        val userName = call.authentication.principal<UserIdPrincipal>()?.name!!
        val gameId = call.request.queryParameters["_id"]!!
        gameService.addUserToRedTeam(userName, gameId)
        call.respondText(call.request.queryParameters["_id"]!!)
    }

    get(JOIN_BLUE) {
        val userName = call.authentication.principal<UserIdPrincipal>()?.name!!
        val gameId = call.request.queryParameters["_id"]!!
        gameService.addUserToBlueTeam(userName, gameId)
        call.respondText(call.request.queryParameters["_id"]!!)
    }
}

