package com.lexmasterteam.numbersinfoapp.presentation.states

import com.lexmasterteam.numbersinfoapp.domain.model.SavedNumberFact

data class NumberfactSavedState(
    val facts: List<SavedNumberFact> = emptyList()
)