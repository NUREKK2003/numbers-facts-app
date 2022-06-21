package com.lexmasterteam.numbersinfoapp.data.remote

import com.lexmasterteam.numbersinfoapp.data.remote.dto.NumberDto
import retrofit2.http.GET

interface NumberApi {

    @GET("/random/math?json")
    suspend fun getNumberFact(): NumberDto
}