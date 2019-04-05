package com.kicker

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.coroutines.runBlocking
import org.litote.kmongo.Id
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.newId
import org.litote.kmongo.reactivestreams.KMongo
import java.time.LocalDateTime


const val ROOT_ENDPOINT = "/"
const val DEMO_ENDPOINT = "/demo"

fun main(args: Array<String>) {
    startServer()
    fillDatabase()
}


fun startServer() {
    val server = embeddedServer(Netty, port = 8080) {
        routing {
            get(ROOT_ENDPOINT) {
                call.respondText("Hello World!", ContentType.Text.Plain)
            }
            get(DEMO_ENDPOINT) {
                call.respondText("HELLO WORLD!")
            }
        }
    }
    server.start(wait = true)
}

fun fillDatabase() {
    val client = KMongo.createClient().coroutine
    val database = client.getDatabase("test")
    val user_col = database.getCollection<User>()
    val team_col = database.getCollection<Team>()
    val match_col = database.getCollection<Match>()

    runBlocking {
        //Insert players
        val userBob = User(newId(), "Bob")
        user_col.insertOne(userBob)
        val userAlice = User(newId(), "Alice")
        user_col.insertOne(userAlice)
        val userMax = User(newId(), "Max")
        user_col.insertOne(userMax)
        val userJohn = User(newId(), "John")
        user_col.insertOne(userJohn)

        //Insert teams
        val teamDefenders = Team(newId(), "teamDefenders", userAlice._id, userBob._id)
        team_col.insertOne(teamDefenders)
        val teamGoodGuys = Team(newId(), "teamGoodGuys", userMax._id, userJohn._id)
        team_col.insertOne(teamGoodGuys)
        val teamSun = Team(newId(), "teamSun", userAlice._id, userJohn._id)
        team_col.insertOne(teamSun)

        //Insert matches
        val goal1 = Goal(newId(), teamDefenders._id, LocalDateTime.now())
        val goal2 = Goal(newId(), teamGoodGuys._id, LocalDateTime.now())
        val goal3 = Goal(newId(), teamGoodGuys._id, LocalDateTime.now())
        val goal4 = Goal(newId(), teamDefenders._id, LocalDateTime.now())
        val goal5 = Goal(newId(), teamGoodGuys._id, LocalDateTime.now())
        val match = Match(
            newId(), teamDefenders._id, teamGoodGuys._id, LocalDateTime.now(), null
            , arrayOf(goal1, goal2, goal3, goal4, goal5)
        )
        match_col.insertOne(match)
    }
}

