package com.sega.compose.screen.root

import androidx.compose.runtime.Composable

import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.sega.compose.screen.splash.SplashContent
import com.sega.compose.screen.welcome.WelcomeContent
import com.sega.module.screen.root.RootScence
import com.sega.module.screen.root.RootScence.Child


@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun RootContent(component: RootScence) {
    Children(
        stack = component.childStack,
        animation = stackAnimation(fade() + scale()),
    ) {
        when (val child = it.instance) {
            is Child.Splash -> SplashContent(child.component)
            is Child.Welcome -> WelcomeContent(child.component)
        }
    }
}
