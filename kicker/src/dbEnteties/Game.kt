package com.kicker

import com.kicker.dbEnteties.Entity
import org.litote.kmongo.Id

data class Game(val _id: Id<Game>, val teamRed: Array<User>, val teamBlue: Array<User>,
                val start_time: java.time.LocalDateTime, val end_time: java.time.LocalDateTime?,
                val goals: Array<Goal>) : Entity {

}