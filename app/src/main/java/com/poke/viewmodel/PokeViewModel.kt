package com.poke.viewmodel

import androidx.lifecycle.ViewModel
import com.poke.domain.usecase.PokeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokeViewModel @Inject constructor(private val useCase: PokeUseCase) : ViewModel() {

}
