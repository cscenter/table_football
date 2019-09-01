package com.kicker.Enteties

data class Goal(
    val teamRed: Array<User>
    , val time: java.time.LocalDateTime
) : Entity()