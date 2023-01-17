package com.tujhe_majhe.splitwisejetpack.presentation.ui.screens.featureAuth.singup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tujhe_majhe.splitwisejetpack.presentation.theme.SplitwiseTheme
import com.example.splitwisejetpack.R

@Preview(showBackground = true)
@Composable
fun ImagePickerForSignUp() {

    val context = LocalContext.current

    SplitwiseTheme {
        Surface() {
            Card(
                modifier = Modifier.width(100.dp),
                elevation = 1.dp
            ) {
                Box(modifier = Modifier.height(120.dp)) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Fit,
                        painter = painterResource(id = R.drawable.no_profile),
                        contentDescription = context.getString(R.string.icon_button_description)
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Box(
                            modifier = Modifier
                                .wrapContentSize()
                                .clip(CircleShape)
                                .padding(6.dp)
                                .clip(shape = CircleShape)
                                .background(
                                    Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Transparent,
                                            if (isSystemInDarkTheme()) Color.Black else Color.LightGray
                                        ),
                                        startY = 300f,
                                    )
                                ),
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(18.dp)
                                    .padding(4.dp),
                                painter = painterResource(id = R.drawable.photo_camera),
                                contentDescription = context.getString(R.string.icon_button_description),
                                tint = if (isSystemInDarkTheme()) Color.LightGray else Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}
