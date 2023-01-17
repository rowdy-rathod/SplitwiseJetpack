package com.tujhe_majhe.splitwisejetpack.presentation.ui.screens.featureAuth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.splitwisejetpack.R
import com.tujhe_majhe.splitwisejetpack.presentation.theme.SplitwiseTheme
import com.tujhe_majhe.splitwisejetpack.presentation.theme.colorSurfaceVariant
import com.tujhe_majhe.splitwisejetpack.presentation.ui.Screens

@Composable
fun Auth(navController: NavController) {
    SplitwiseTheme() {
        ConstraintLayout(
            Modifier.defaultMinSize(minHeight = 450.dp),

            ) {
            val (buttons) = createRefs()
            Buttons(navController, modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .constrainAs(buttons) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
            )
        }
    }

}

@Composable
fun Buttons(navController: NavController, modifier: Modifier) {
    val context = LocalContext.current
    Surface {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {

            Button(
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp
                ),
                border = BorderStroke(1.dp, color = MaterialTheme.colors.colorSurfaceVariant()),
                onClick = { navController.navigate(Screens.SignUpScreen.route) },
                modifier = Modifier
                    .height(48.dp)
                    .weight(1f)
            ) {
                Text(text = context.getString(R.string.label_signup))
            }

            OutlinedButton(
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp
                ),
                border = BorderStroke(1.dp, color = MaterialTheme.colors.colorSurfaceVariant()),
                onClick = { navController.navigate(Screens.SignInScreen.route) },

                modifier = Modifier
                    .height(48.dp)
                    .padding(start = 8.dp)
                    .weight(1f)
            ) {
                Text(text = context.getString(R.string.label_signin))
            }
        }
    }
}
