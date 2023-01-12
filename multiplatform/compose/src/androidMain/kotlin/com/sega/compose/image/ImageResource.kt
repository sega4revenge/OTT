package com.sega.compose.image

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.sega.compose.R

actual object ImageResource {
    @SuppressLint("DiscouragedApi")
    @Composable
    actual fun localResource(name: String) = painterResource(
        LocalContext.current.resources.getIdentifier(
            name,
            "drawable", LocalContext.current.packageName
        )
    )
}
