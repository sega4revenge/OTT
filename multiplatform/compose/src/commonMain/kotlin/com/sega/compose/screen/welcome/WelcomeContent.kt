package com.sega.compose.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sega.module.screen.welcome.WelcomeScene
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import com.sega.compose.constants.ImageConstant
import com.sega.compose.image.ImageResource

@Composable
fun WelcomeContent(component: WelcomeScene) {
    Box {
        Image(
            painter = ImageResource.localResource(ImageConstant.welcomeBackground),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.padding(top = 125.dp)
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                TextButton(
                    onClick = component::tapLogin
                ) {
                    Text(
                        text = "Login",
                        fontSize = 12.sp,
                        color = MaterialTheme.colors.onSurface
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = ">",
                        fontSize = 12.sp,
                        color = MaterialTheme.colors.onSurface
                    )
                }
            }


            Text(modifier = Modifier.padding(top = 60.dp),
                text = "Welcome to".uppercase(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Black)

            Spacer(modifier = Modifier.height(13.dp))

            Image(
                painter = ImageResource.localResource(ImageConstant.splashLogo),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.height(32.dp)
            )
        }
    }



}