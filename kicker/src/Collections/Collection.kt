package com.kicker.Collections

import com.kicker.Enteties.Entity

interface Collection<T: Entity>{

    fun add(record: T): String?

    fun getAll(): List<T>

    fun getById(id: String): T?

    fun getByName(name: String): T?

    fun remove(id: String)

    fun clear()
}