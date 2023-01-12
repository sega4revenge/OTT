package com.sega.module.screen.splash

interface SplashScene {
    fun onFinishPreparing()

    sealed class Output {
        object finishPreparing : Output()
    }
}
