package com.lexmasterteam.numbersinfoapp.domain.use_case.internal

import com.lexmasterteam.numbersinfoapp.domain.model.SavedNumberFact
import com.lexmasterteam.numbersinfoapp.domain.repository.NumberFactSavedRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNumberFacts(
    private val repository: NumberFactSavedRepository
) {

    operator fun invoke():Flow<List<SavedNumberFact>>{
        return repository.getNumberFacts().map { facts ->
            facts.sortedBy { it.id }
        }
    }
}