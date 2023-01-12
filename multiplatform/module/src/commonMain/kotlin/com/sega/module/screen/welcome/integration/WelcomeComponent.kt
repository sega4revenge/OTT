package com.sega.module.screen.welcome.integration

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.badoo.reaktive.base.Consumer
import com.badoo.reaktive.base.invoke
import com.sega.module.screen.welcome.WelcomeScene.Output
import com.sega.module.screen.welcome.store.WelcomeStoreProvider
import com.sega.module.screen.welcome.WelcomeScene

class WelcomeComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
    private val output: Consumer<Output>
) : WelcomeScene, ComponentContext by componentContext {

    private val store =
        instanceKeeper.getStore {
            WelcomeStoreProvider(
                storeFactory = storeFactory
            ).provide()
        }

    override fun tapLogin() {
        output(Output.goToLogin)
    }

    override fun subscribe() {
        output(Output.subscribe)
    }
}
