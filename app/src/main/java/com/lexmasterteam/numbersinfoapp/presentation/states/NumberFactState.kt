package com.lexmasterteam.numbersinfoapp.presentation.states

import com.lexmasterteam.numbersinfoapp.domain.model.NumberFact

data class NumberFactState(
    val isLoading:Boolean = false,
    val numberFact: NumberFact? = null,
    val error: String = ""
)
