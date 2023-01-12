package com.sega.ott.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.mvikotlin.logging.store.LoggingStoreFactory
import com.arkivanov.mvikotlin.timetravel.store.TimeTravelStoreFactory
import com.sega.compose.screen.root.RootContent
import com.sega.compose.theme.AppTheme
import com.sega.module.screen.root.RootScence
import com.sega.module.screen.root.integration.RootComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = rootComponent(defaultComponentContext())
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RootContent(component = root)
                }
            }
        }
    }
}

private fun rootComponent(componentContext: ComponentContext): RootScence =
    RootComponent(
        componentContext = componentContext,
        storeFactory = LoggingStoreFactory(TimeTravelStoreFactory())
    )