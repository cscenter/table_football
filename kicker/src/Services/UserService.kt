package com.kicker.Services

import com.kicker.Collections.UserCollection
import com.kicker.Enteties.User
import com.kicker.kodein
import io.ktor.auth.UserIdPrincipal
import org.kodein.di.generic.instance

class UserService {
    private val userCollection: UserCollection by kodein.instance()
    fun register(name: String, password: String): UserIdPrincipal? {
        val userId = userCollection.add(User(nickName = name, password = password))
        if (userId != null) {
            return UserIdPrincipal(userId)
        }
        return null
    }

    fun authenticateUser(name: String, password: String): UserIdPrincipal? {
        val user = userCollection.getByName(name)
        if (user?.nickName == name && user.password == password) {
            return UserIdPrincipal(name)
        } else {
            return null
        }
    }

}

