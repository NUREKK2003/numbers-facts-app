package com.lexmasterteam.numbersinfoapp.domain.use_case.internal

import com.lexmasterteam.numbersinfoapp.domain.model.InvalidNumberFactException
import com.lexmasterteam.numbersinfoapp.domain.model.SavedNumberFact
import com.lexmasterteam.numbersinfoapp.domain.repository.NumberFactSavedRepository

class AddNumberFact(
    private val repository: NumberFactSavedRepository
) {
    @Throws(InvalidNumberFactException::class)
    suspend operator fun invoke(fact: SavedNumberFact){
        repository.insertNumberFact(fact)
    }
}