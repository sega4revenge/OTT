package com.sega.module.screen.splash.integration

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.badoo.reaktive.base.Consumer
import com.badoo.reaktive.base.invoke
import com.sega.module.screen.splash.SplashScene
import com.sega.module.screen.welcome.store.WelcomeStoreProvider

class SplashComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
    private val output: Consumer<SplashScene.Output>
) : SplashScene, ComponentContext by componentContext {

    private val store =
        instanceKeeper.getStore {
            WelcomeStoreProvider(
                storeFactory = storeFactory
            ).provide()
        }

    override fun onFinishPreparing() {
        output(SplashScene.Output.finishPreparing)
    }
}
