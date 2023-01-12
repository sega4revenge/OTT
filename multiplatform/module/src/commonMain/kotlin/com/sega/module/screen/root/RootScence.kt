package com.sega.module.screen.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.sega.module.screen.splash.SplashScene
import com.sega.module.screen.welcome.WelcomeScene

interface RootScence {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        data class Splash(val component: SplashScene) : Child()
        data class Welcome(val component: WelcomeScene) : Child()
    }
}
