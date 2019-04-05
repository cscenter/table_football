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
    createDatabase()
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

fun createDatabase(){
    val client = KMongo.createClient().coroutine
    val database = client.getDatabase("test")
}