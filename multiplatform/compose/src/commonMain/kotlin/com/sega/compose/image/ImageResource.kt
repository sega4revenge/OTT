package com.sega.compose.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

expect object ImageResource {
    @Composable
    fun localResource(name: String): Painter
}