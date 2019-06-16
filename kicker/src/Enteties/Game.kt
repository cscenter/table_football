package com.kicker.Enteties

import java.time.LocalDateTime

data class Game(
    val creationTime: LocalDateTime
    , val teamRed: MutableList<String> = mutableListOf<String>()
    , val teamBlue: MutableList<String> = mutableListOf<String>()
    , var startTime: LocalDateTime? = null
    , var endTime: LocalDateTime? = null
    , val goals: Array<Goal>? = null
) : Entity()

data class Games(val items: List<Game>)