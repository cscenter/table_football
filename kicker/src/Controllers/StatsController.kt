package com.kicker.Controllers

import com.kicker.Services.StatsService
import com.kicker.kodein
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import org.kodein.di.generic.instance

private const val RATING_ENDPOINT = "/kiker/rating"

class StatsController {

    private fun showHomepage() {}
    private val statsService: StatsService by kodein.instance()
}

fun Route.statsController() {
    get(RATING_ENDPOINT) {
        call.respondText("stats")
    }
}