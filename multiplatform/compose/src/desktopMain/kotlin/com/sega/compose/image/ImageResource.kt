package com.sega.compose.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

actual object ImageResource {
    @Composable
    actual fun localResource(name: String) = painterResource(
        "images/${name}.png"
    )
}