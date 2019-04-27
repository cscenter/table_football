package com.kicker.Enteties

import java.time.LocalDateTime

data class Game(
    val _id: String? = null
    , val creationTime: LocalDateTime
    , val teamRed: Array<User>? = null
    , val teamBlue: Array<User>? = null
    , val startTime: LocalDateTime? = null
    , val endTime: LocalDateTime? = null
    , val goals: Array<Goal>? = null
) : Entity