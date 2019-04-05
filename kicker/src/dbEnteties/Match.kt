package com.kicker

import org.litote.kmongo.Id

data class Match(val _id: Id<Match>, val team1_id: Id<Team>, val team2_id: Id<Team>
                 , val start_time: java.time.LocalDateTime, val end_time: java.time.LocalDateTime?,
                 val goals: Array<Goal>)