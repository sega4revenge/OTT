package com.sega.module.screen.root.integration

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.badoo.reaktive.base.Consumer
import com.sega.module.ext.Consumer
import com.sega.module.manager.LogManager
import com.sega.module.screen.root.RootScence
import com.sega.module.screen.root.RootScence.Child
import com.sega.module.screen.splash.SplashScene
import com.sega.module.screen.splash.integration.SplashComponent
import com.sega.module.screen.welcome.WelcomeScene
import com.sega.module.screen.welcome.integration.WelcomeComponent


class RootComponent internal constructor(
    componentContext: ComponentContext,
    private val splashScene: (ComponentContext, Consumer<SplashScene.Output>) -> SplashScene,
    private val welcomeScene: (ComponentContext, Consumer<WelcomeScene.Output>) -> WelcomeScene
) : RootScence, ComponentContext by componentContext {

    constructor(
        componentContext: ComponentContext,
        storeFactory: StoreFactory
    ) : this(
        componentContext = componentContext,
        splashScene = { childContext, output ->
            SplashComponent(
                componentContext = childContext,
                storeFactory = storeFactory,
                output = output
            )
        },
        welcomeScene = { childContext, output ->
            WelcomeComponent(
                componentContext = childContext,
                storeFactory = storeFactory,
                output = output
            )
        }
    )

    private val navigation = StackNavigation<Configuration>()

    private val stack =
        childStack(
            source = navigation,
            initialConfiguration = Configuration.Splash,
            handleBackButton = true,
            childFactory = ::createChild
        )

    override val childStack: Value<ChildStack<*, Child>> = stack

    private fun createChild(configuration: Configuration, componentContext: ComponentContext): Child =
        when (configuration) {
            is Configuration.Splash -> Child.Splash(splashScene(componentContext, Consumer(::onSplashOutput)))
            is Configuration.Welcome -> Child.Welcome(welcomeScene(componentContext, Consumer(::onWelcomeOutput)))
        }

    private fun onSplashOutput(output: SplashScene.Output): Unit =
        when (output) {
            is SplashScene.Output.finishPreparing -> {
                LogManager.log("Tap Finish")
                navigation.push(Configuration.Welcome)
            }
        }

    private fun onWelcomeOutput(output: WelcomeScene.Output): Unit =
        when (output) {
            is WelcomeScene.Output.goToLogin -> {
                LogManager.log("Tap To Login")
            }
            is WelcomeScene.Output.subscribe -> {
                LogManager.log("Tap To Subscribe")
            }
        }

    private sealed class Configuration : Parcelable {
        @Parcelize
        object Splash : Configuration()

        @Parcelize
        object Welcome : Configuration()
    }
}
