package com.sega.compose.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sega.compose.constants.ColorConstant
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
            val density = LocalDensity.current.density
            Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()) {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(start = 20.dp, bottom = 40.dp).width(IntrinsicSize.Min)) {

                    Text(text = "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit")

                    GradientButton("Try For 1 Month Free", Brush.horizontalGradient(ColorConstant.gradientButton),
                        onClick = component::subscribe)
                }
            }
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
        colors = ButtonDefaults.buttonColors(contentColor = Color.White),
        contentPadding = PaddingValues(),
        onClick = { onClick() },
    ) {
        Box(
            modifier = Modifier
                    .background(gradient)
                    .padding(16.dp)
                    .width(IntrinsicSize.Max),
        ) {
            Text(text = text)
        }
    }
}