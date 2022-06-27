package com.lexmasterteam.numbersinfoapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SavedNumberFact(
    var number: Int,
    var fact: String,
    @PrimaryKey var id: Int? = null
)

class InvalidNumberFactException(message: String): Exception(message)
