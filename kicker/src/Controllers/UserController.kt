package com.kicker.Controllers

import io.ktor.application.call
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.request.receiveParameters
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route

const val REGISTER_ENDPOINT = "/register"
const val LOGIN_ENDPOINT = "/login"

class UserController {
    fun validCredentials(username: String?, password: String?): Boolean {
        return username != null && username == password
    }
}

fun Route.userController() {
    get(REGISTER_ENDPOINT) {
        call.respondText("register")
    }

    route(LOGIN_ENDPOINT) {
        get {
            call.respond(FreeMarkerContent("login.ftl", null))
        }
        post {
            val post = call.receiveParameters()
            if (post["username"] != null && post["username"] == post["password"]) {
                call.respondText("OK")
            } else {
                call.respond(FreeMarkerContent("login.ftl", mapOf("error" to "Invalid login")))
            }
        }
    }
}