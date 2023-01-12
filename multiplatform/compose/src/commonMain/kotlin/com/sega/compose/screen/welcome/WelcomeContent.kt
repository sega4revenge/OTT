package com.sega.compose.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sega.compose.constants.ImageConstant
import com.sega.compose.image.ImageResource
import com.sega.module.screen.welcome.WelcomeScene


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


            Text(modifier = Modifier.padding(top = 35.dp),
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

            Box(Modifier.weight(1.0f))

            GradientButton("Try For 1 Month Free", Brush.horizontalGradient(listOf(Color(0xFF28D8A3), Color(0xFF00BEB2))), modifier = Modifier
                    .padding(horizontal = 23.dp, vertical = 17.dp),
                onClick = component::subscribe)
        }
    }



}

@Composable
fun GradientButton(
    text: String,
    gradient : Brush,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        onClick = { onClick() },
    ) {
        Box(
            modifier = Modifier
                    .background(gradient)
                    .then(modifier),
        ) {
            Text(text = text)
        }
    }
}