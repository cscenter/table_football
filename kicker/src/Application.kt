package com.kicker

import com.kicker.Collections.GameCollection
import com.kicker.Collections.UserCollection
import com.kicker.Controllers.*
import com.kicker.Services.GameService
import com.kicker.Services.StatsService
import com.kicker.Services.UserService
import com.mongodb.client.MongoDatabase
import freemarker.cache.ClassTemplateLoader
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.freemarker.FreeMarker
import io.ktor.response.respondText
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import org.litote.kmongo.*

fun main(args: Array<String>) {
    startServer(args)
}

val kodein = Kodein {
    bind<GameCollection>() with singleton { GameCollection() }
    bind<UserCollection>() with singleton { UserCollection() }
    bind<GameController>() with singleton { GameController() }
    bind<UserController>() with singleton { UserController() }
    bind<StatsController>() with singleton { StatsController() }
    bind<GameService>() with singleton { GameService() }
    bind<StatsService>() with singleton { StatsService() }
    bind<UserService>() with singleton { UserService() }
    bind<MongoDatabase>() with singleton {
        val client = KMongo.createClient()
        val database = client.getDatabase("test")
        database
    }
}

fun startServer(args: Array<String>) {
    val server = embeddedServer(Netty, port = 8080) {
        install(FreeMarker) {
            templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
        }

        val userService: UserService by kodein.instance()


        routing {
            registerUser()

            install(Authentication) {
                basic(name = "myauth1") {
                    validate { credentials ->
                        val principal = userService.authenticateUser(credentials.name, credentials.password)
                        if (principal != null) {
                            principal
                        } else {
                            null
                        }
                    }
                }

            }

            authenticate("myauth1") {
                gameController()
                userController()
                statsController()
                get("/") {
                    call.respondText { call.authentication.principal<UserIdPrincipal>()?.name!! }
                }

            }
        }

    }
    server.start(wait = true)
}