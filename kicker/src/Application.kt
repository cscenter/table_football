package com.kicker

import com.kicker.Controllers.UserController
import com.kicker.Controllers.gameController
import com.kicker.Controllers.statsController
import com.kicker.Controllers.userController
import freemarker.cache.ClassTemplateLoader
import io.ktor.application.*
import io.ktor.freemarker.FreeMarker
import io.ktor.response.respondRedirect
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
        install(FreeMarker) {
            templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
        }
        routing {
            gameController()
            userController()
            statsController()
            get("/") {
                call.respondRedirect("/login", permanent = false)
            }
        }

    }
    server.start(wait = true)
}

fun createDatabase(){
    val client = KMongo.createClient().coroutine
    val database = client.getDatabase("test")
}
