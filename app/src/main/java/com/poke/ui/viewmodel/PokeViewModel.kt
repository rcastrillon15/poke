package com.poke.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.poke.domain.usecase.PokeUseCase
import javax.inject.Inject

class PokeViewModel @Inject constructor(private val useCase: PokeUseCase) : ViewModel() {

}
