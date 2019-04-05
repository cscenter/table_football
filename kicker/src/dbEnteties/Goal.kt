package com.kicker

import org.litote.kmongo.Id

data class Goal(val _id: Id<User>, val team: Id<Team>, val time: java.time.LocalDateTime)