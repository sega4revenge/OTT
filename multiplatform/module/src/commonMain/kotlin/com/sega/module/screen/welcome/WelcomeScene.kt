package com.sega.module.screen.welcome

interface WelcomeScene {
    fun tapLogin()
    fun subscribe()

    sealed class Output {
        object goToLogin : Output()
        object subscribe : Output()
    }
}
