package com.lexmasterteam.numbersinfoapp.domain.use_case.internal

import com.lexmasterteam.numbersinfoapp.domain.repository.NumberFactSavedRepository

data class NumbersFactUseCases(
    val getNumberFacts: GetNumberFacts,
    val addNumberFact: AddNumberFact
)