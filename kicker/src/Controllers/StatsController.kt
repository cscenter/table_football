package com.kicker.Controllers


import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

const val RATING_ENDPOINT = "/kiker/rating"

class StatsController {

    fun startServer() {
        val server = embeddedServer(Netty, port = 8080) {
            routing {
                get(RATING_ENDPOINT) {
                    call.respondText("Hello World!", ContentType.Text.Plain)
                }

            }
        }
        server.start(wait = true)
    }

    fun showHomepage() {}
}