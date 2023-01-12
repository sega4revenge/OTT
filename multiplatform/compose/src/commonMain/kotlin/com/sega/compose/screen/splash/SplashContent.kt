package com.sega.compose.screen.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.sega.compose.constants.ColorConstant
import com.sega.compose.constants.ImageConstant
import com.sega.module.screen.splash.SplashScene
import com.sega.compose.image.ImageResource
import kotlinx.coroutines.delay

@Composable
fun SplashContent(component: SplashScene) {
    Box(Modifier.fillMaxSize()) {
        Box(
            Modifier.align(Alignment.Center)
        ) {
            Image(
                painter = ImageResource.localResource(ImageConstant.splashLogo),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        val scale = remember {
            Animatable(0.0f)
        }

        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 0.7f,
                animationSpec = tween()
            )
            delay(1000)
            component.onFinishPreparing()
        }
    }
}