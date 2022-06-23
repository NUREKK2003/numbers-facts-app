package com.lexmasterteam.numbersinfoapp.data.internal.repository

import com.lexmasterteam.numbersinfoapp.data.internal.data_source.NumberFactDao
import com.lexmasterteam.numbersinfoapp.domain.model.SavedNumberFact
import com.lexmasterteam.numbersinfoapp.domain.repository.NumberFactSavedRepository
import kotlinx.coroutines.flow.Flow

class NumberFactSavedRepositoryImpl(
    private val dao:NumberFactDao
) : NumberFactSavedRepository{
    override fun getNumberFacts(): Flow<List<SavedNumberFact>> {
        return dao.getNumberFacts()
    }

    override suspend fun insertNumberFact(fact: SavedNumberFact) {
        dao.insertNumberFact(fact)
    }
}