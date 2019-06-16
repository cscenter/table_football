package com.kicker.Controllers

import com.kicker.Collections.UserCollection
import com.kicker.Enteties.User
import com.kicker.Enteties.Users
import com.kicker.kodein
import io.ktor.application.call
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.request.receiveParameters
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import org.kodein.di.generic.instance

private const val REGISTER_ENDPOINT = "/register"
private const val ALL_USERS = "/allusers"

class UserController {
    val userCollection: UserCollection by kodein.instance()
    fun getAllUsers(): List<User> {
        val users = userCollection.getAll()
        return users
    }

    fun isValidCredential(name: String?, password: String?): Boolean {
        return (name != null && name == password)
    }

    fun registerUser(name: String, password: String): String? {
        return userCollection.add(User(nickName = name, password = password))
    }
}

fun Route.userController() {
    val userController: UserController by kodein.instance()

    get(ALL_USERS) {
        val users = userController.getAllUsers()
        call.respond(FreeMarkerContent("allUsers.ftl", mapOf("data" to Users(users)), ""))
    }
}

fun Route.registerUser() {
    val userController: UserController by kodein.instance()
    route(REGISTER_ENDPOINT) {
        get {
            call.respond(FreeMarkerContent("login.ftl", null))
        }
        post {
            val post = call.receiveParameters()
            val name = post["username"]!!
            val password = post["password"]!!
            if (userController.isValidCredential(name, password) && userController.registerUser(
                    name,
                    password
                ) != null
            ) {
                call.respondText { "Registered successfully" }
            } else {
                call.respond(FreeMarkerContent("login.ftl", mapOf("error" to "Invalid login")))
            }
        }
    }
}