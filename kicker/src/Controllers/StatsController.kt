package com.kicker.Controllers

import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get

const val RATING_ENDPOINT = "/kiker/rating"

class StatsController {

    fun showHomepage() {}
}

fun Route.statsController() {
    get(RATING_ENDPOINT) {
        call.respondText("stats")
    }
}