package com.kicker.Services

import com.kicker.Collections.UserCollection
import com.kicker.kodein
import io.ktor.auth.UserIdPrincipal
import org.kodein.di.generic.instance

class UserService {
    private val userCollection: UserCollection by kodein.instance()

    fun authenticateUser(name: String, password: String): UserIdPrincipal? {
        val user = userCollection.getByName(name)
        return if (user?.nickName == name && user.password == password) {
            UserIdPrincipal(name)
        } else {
            null
        }
    }

}

