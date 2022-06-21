package com.lexmasterteam.numbersinfoapp.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lexmasterteam.numbersinfoapp.common.Resource
import com.lexmasterteam.numbersinfoapp.domain.use_case.GetNumberFactUseCase
import com.lexmasterteam.numbersinfoapp.presentation.states.NumberFactState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NumberFactViewModel @Inject constructor(
    private val getNumberFactUseCase: GetNumberFactUseCase
): ViewModel(){
    private val _state = mutableStateOf(NumberFactState())

    init {
        getNumberFact()
    }

    private fun getNumberFact() {
        getNumberFactUseCase().onEach { result ->
            when(result){
                is Resource.Succes ->{
                    _state.value = NumberFactState(numberFact = result.data)
                }
                is Resource.Error ->{
                    _state.value = NumberFactState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading ->{
                    _state.value = NumberFactState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}