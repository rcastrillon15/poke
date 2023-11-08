package com.poke.common.helper

sealed class LoadState<out T> {
    object Idle : LoadState<Nothing>()
    object InFlight : LoadState<Nothing>()
    object Failure : LoadState<Nothing>()
    data class Success<out T>(val data: T) : LoadState<T>()
}

data class ViewState<T>(
    val data: T,
    val loadType: LoadType = LoadType.Load,
    val failed: Boolean = false
) {

    val isLoading
        get() = loadType == LoadType.Load

    fun asFailure() = copy(loadType = LoadType.Idle, failed = true)

    fun asSuccess(input: T) =
        copy(loadType = LoadType.Idle, failed = false, data = input)

    enum class LoadType {
        Idle,
        Load
    }
}
