package com.poke.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poke.common.helper.ViewState
import com.poke.domain.usecase.PokeUseCase
import com.poke.mapper.toPokeState
import com.poke.state.PokeState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class PokeViewModel @Inject constructor(private val useCase: PokeUseCase) : ViewModel() {

    private val _viewState = MutableStateFlow(ViewState(PokeState()))
    val viewState = _viewState.asStateFlow()

    init {
        getPoke()
    }

    private fun getPoke() {
        viewModelScope.launch {
            val state = useCase.getPoke()
                .fold(
                    {
                        _viewState.value.asFailure()
                    }, { model ->
                        _viewState.value.asSuccess(model.toPokeState())
                    }
                )
            _viewState.update { state }
        }
    }
}
