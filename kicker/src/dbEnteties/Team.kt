package com.kicker

import org.litote.kmongo.Id

data class Team(val _id: Id<Team>, val name: String, val user1_id: Id<User>, val user2_id: Id<User>)