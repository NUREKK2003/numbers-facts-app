package com.lexmasterteam.numbersinfoapp.domain.repository

import com.lexmasterteam.numbersinfoapp.data.remote.dto.NumberDto

interface NumberRepository {
    suspend fun getNumberFact(): NumberDto
}