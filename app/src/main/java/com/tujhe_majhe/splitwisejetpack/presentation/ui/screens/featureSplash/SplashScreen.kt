package com.tujhe_majhe.splitwisejetpack.presentation.ui.screens.featureSplash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.splitwisejetpack.R
import com.example.splitwisejetpack.BuildConfig
import com.tujhe_majhe.splitwisejetpack.presentation.theme.SplitwiseTheme
import com.tujhe_majhe.splitwisejetpack.presentation.ui.Screens
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
fun SplashScreen(navController: NavController? = null) {
    SplitwiseTheme {
        Surface() {
            Box(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {

                val scale = remember {
                    androidx.compose.animation.core.Animatable(0.0f)
                }

                LaunchedEffect(key1 = true) {
                    scale.animateTo(
                        targetValue = 0.7f,
                        animationSpec = tween(
                            800,
                            easing = {
                                OvershootInterpolator(4f).getInterpolation(it)
                            }
                        )
                    )
                    delay(3000L)
                    navController?.navigate(Screens.AuthScreen.route) {
                        // this line will be clear backstack
                        popUpTo(Screens.SplashScreen.route) { inclusive = true }
                    }
                }

                Image(
                    painter = painterResource(id = R.drawable.no_profile),
                    contentDescription = "",
                    alignment = Alignment.Center, modifier = Modifier
                        .fillMaxSize()
                        .padding(40.dp)
                        .scale(scale.value)

                )

                Text(
                    text = "Version - ${BuildConfig.VERSION_NAME}",
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp)
                )
            }
        }
    }
}
