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

data class User(val _id: Id<User>, val nickName: String)
data class Team(val _id: Id<Team>, val name: String, val user1_id: Id<User>, val user2_id: Id<User>)
data class Goal(val _id: Id<User>, val team: Id<Team>, val time: java.time.LocalDateTime)
data class Match(val _id: Id<Match>, val team1_id: Id<Team>, val team2_id: Id<Team>
                 , val start_time: java.time.LocalDateTime, val end_time: java.time.LocalDateTime?,
                 val goals: Array<Goal>)

fun main(args: Array<String>) {
//    startServer()
    fillDatabase()
}

fun startServer() {
    val server = embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                call.respondText("Hello World!", ContentType.Text.Plain)
            }
            get("/demo") {
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
        val match = Match(newId(), teamDefenders._id, teamGoodGuys._id, LocalDateTime.now(), null
            , arrayOf(goal1, goal2, goal3, goal4, goal5))
        match_col.insertOne(match)
    }
}

