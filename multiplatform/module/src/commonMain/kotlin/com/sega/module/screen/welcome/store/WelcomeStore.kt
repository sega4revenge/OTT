package com.sega.module.screen.welcome.store

import com.arkivanov.mvikotlin.core.store.Store


internal interface WelcomeStore : Store<WelcomeStore.Intent, WelcomeStore.State, Nothing> {
    sealed class Intent {
        object Login : Intent()
        object Subscribe
    }

    data class State(
        val tapLogin: Boolean = false,
        val tapSubscribe: Boolean = false
    )
}
