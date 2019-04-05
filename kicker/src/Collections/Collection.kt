package com.kicker.Collections

import com.kicker.dbEnteties.Entity

interface Collection<T: Entity> {

    fun add(record: T): T

    fun getAll()

    fun get(id: Int): T

    fun remove(id: Int)

    fun clear()
}