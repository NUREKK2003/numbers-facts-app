package com.lexmasterteam.numbersinfoapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SavedNumberFact(
    val number: Int,
    val fact: String,
    @PrimaryKey val id: Int? = null
)

class InvalidNumberFactException(message: String): Exception(message)
