package com.kicker.Controllers

import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get

const val REGISTER_ENDPOINT = "/register"

class UserController {
}

fun Route.userController() {
    get(REGISTER_ENDPOINT) {
        call.respondText("register")
    }
}