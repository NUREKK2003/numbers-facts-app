package com.lexmasterteam.numbersinfoapp.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.lexmasterteam.numbersinfoapp.domain.model.NumberFact
import com.lexmasterteam.numbersinfoapp.domain.model.SavedNumberFact
import com.lexmasterteam.numbersinfoapp.domain.use_case.internal.NumbersFactUseCases
import com.lexmasterteam.numbersinfoapp.presentation.states.NumberfactSavedState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.time.Duration
import javax.inject.Inject
import kotlin.time.ExperimentalTime
import kotlin.time.seconds


@HiltViewModel
class NumbersFactsSavedViewModel @Inject constructor(
    private val numbersFactUseCases: NumbersFactUseCases
): ViewModel() {
    private val _state = mutableStateOf(NumberfactSavedState())
    val state:State<NumberfactSavedState> = _state



    private var getNumbersFactSavedJob: Job? = null

    init{
        getNumbersFactsSaved()
    }

    private fun getNumbersFactsSaved() {
        getNumbersFactSavedJob?.cancel()
        getNumbersFactSavedJob = numbersFactUseCases.getNumberFacts()
            .onEach { facts->
                _state.value = state.value.copy(
                    facts = facts
                )
            }
            .launchIn(viewModelScope)
    }

    suspend fun addNumberFact(fact: SavedNumberFact){
        numbersFactUseCases.addNumberFact(fact)
    }


    fun observeState(): LiveData<NumberfactSavedState>{
        return state
    }


}