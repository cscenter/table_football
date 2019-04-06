package com.kicker

import com.kicker.Controllers.gameController
import com.kicker.Controllers.statsController
import com.kicker.Controllers.userController
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

fun main(args: Array<String>) {
    startServer()
    createDatabase()
}


fun startServer() {
    val server = embeddedServer(Netty, port = 8080) {
        routing {
            gameController()
            userController()
            statsController()
        }

    }
    server.start(wait = true)
}

fun createDatabase(){
    val client = KMongo.createClient().coroutine
    val database = client.getDatabase("test")
}
