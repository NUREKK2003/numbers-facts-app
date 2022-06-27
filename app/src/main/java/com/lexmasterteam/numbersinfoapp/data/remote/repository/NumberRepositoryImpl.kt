package com.lexmasterteam.numbersinfoapp.data.remote.repository

import android.util.Log
import com.lexmasterteam.numbersinfoapp.data.remote.NumberApi
import com.lexmasterteam.numbersinfoapp.data.remote.dto.NumberDto
import com.lexmasterteam.numbersinfoapp.domain.repository.NumberRepository
import javax.inject.Inject

class NumberRepositoryImpl @Inject constructor(
    private val api:NumberApi
) :NumberRepository {
    override suspend fun getNumberFact(): NumberDto {
        return api.getNumberFact()

    }
}