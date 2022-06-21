package com.lexmasterteam.numbersinfoapp.domain.use_case

import com.lexmasterteam.numbersinfoapp.common.Resource
import com.lexmasterteam.numbersinfoapp.data.remote.dto.toNumberFact
import com.lexmasterteam.numbersinfoapp.data.remote.repository.NumberRepositoryImpl
import com.lexmasterteam.numbersinfoapp.domain.model.NumberFact
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNumberFactUseCase @Inject constructor(
    private val repository: NumberRepositoryImpl
) {

    operator fun invoke(): Flow<Resource<NumberFact>> = flow {
        try {
            emit(Resource.Loading())

            val numberFact = repository.getNumberFact().toNumberFact()
            emit(Resource.Succes(numberFact))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}