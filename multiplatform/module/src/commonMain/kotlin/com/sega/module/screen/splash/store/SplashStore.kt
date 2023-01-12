package com.sega.module.screen.splash.store

import com.arkivanov.mvikotlin.core.store.Store


internal interface SplashStore : Store<SplashStore.Intent, SplashStore.State, Nothing> {
    sealed class Intent {
        object Done : Intent()
    }

    data class State(
        val loading: Boolean = false
    )
}
