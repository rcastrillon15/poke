package com.poke.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poke.common.Constants.PAGE_SIZE
import com.poke.common.helper.LoadState
import com.poke.common.helper.ViewState
import com.poke.domain.usecase.PokeUseCase
import com.poke.mapper.toState
import com.poke.state.PokeSpecieState
import com.poke.state.PokeState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class PokeViewModel @Inject constructor(private val useCase: PokeUseCase) : ViewModel() {

    private var currentPage = 0
    private var endReached = mutableStateOf(false)

    var pokeId = mutableStateOf(0)
    var errorMessage = mutableStateOf("")

    private val _viewState = MutableStateFlow(ViewState(PokeState()))
    val viewState = _viewState.asStateFlow()

    private val _pokeSpecieState = MutableStateFlow(ViewState(PokeSpecieState()))
    val pokeSpecieState = _pokeSpecieState.asStateFlow()

    init {
        getPoke()
    }

    fun getPoke() {
        _viewState.value.isLoading
        viewModelScope.launch {

            _viewState.update { state ->
                useCase.getPoke(limit = PAGE_SIZE, offset = currentPage * PAGE_SIZE)
                    .fold(
                        {
                            errorMessage.value = it.toString()
                            _viewState.value.asFailure()
                        }, { model ->
                            endReached.value = currentPage * PAGE_SIZE >= state.data.results.count()
                            currentPage++
                            _viewState.value.asSuccess(model.toState())
                        }
                    )
            }
        }
    }

    fun getPokemonSpecies() {
        _pokeSpecieState.value.isLoading
        viewModelScope.launch {
            _pokeSpecieState.update {
                useCase.getPokemonSpecies(pokeId.value)
                    .fold(
                        {
                            errorMessage.value = it.toString()
                            _pokeSpecieState.value.asFailure()
                        }, { model ->
                            _pokeSpecieState.value.asSuccess(model.toState())
                        }
                    )
            }
        }
    }

    fun pullRefresh() {
        getPoke()
    }
}
