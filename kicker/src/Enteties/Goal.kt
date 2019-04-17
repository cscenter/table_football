package com.kicker.Enteties

import org.litote.kmongo.Id

data class Goal(val _id: Id<User>?, val teamRed: Array<User>, val time: java.time.LocalDateTime) : Entity