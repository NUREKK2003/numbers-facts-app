package com.lexmasterteam.numbersinfoapp.data.remote.dto

import com.lexmasterteam.numbersinfoapp.domain.model.NumberFact

data class NumberDto(
    val found: Boolean,
    val number: Int,
    val text: String,
    val type: String
)
fun NumberDto.toNumberFact(): NumberFact{
    return NumberFact(
        text = text,
        number = number
    )
}