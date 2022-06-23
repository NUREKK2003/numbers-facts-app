package com.lexmasterteam.numbersinfoapp.domain.repository

import com.lexmasterteam.numbersinfoapp.domain.model.SavedNumberFact
import kotlinx.coroutines.flow.Flow


interface NumberFactSavedRepository {

    fun getNumberFacts(): Flow<List<SavedNumberFact>>

    suspend fun insertNumberFact(fact: SavedNumberFact)
}