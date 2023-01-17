package com.tujhe_majhe.splitwisejetpack.presentation.ui.screens.featureAuth.signin

import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.splitwisejetpack.R
import com.tujhe_majhe.splitwisejetpack.presentation.theme.DarkTextFieldColor
import com.tujhe_majhe.splitwisejetpack.presentation.theme.LightTextFieldColor
import com.tujhe_majhe.splitwisejetpack.presentation.theme.SplitwiseTheme

@Preview(showBackground = true)
@Composable
fun SignInScreen(navController: NavController? = null) = SplitwiseTheme {

    var userEmail by remember { mutableStateOf(TextFieldValue("")) }

    var passwordVisibility by remember { mutableStateOf(false) }

    var userPassword by remember { mutableStateOf("") }

    val context = LocalContext.current

    Surface {
        SplitwiseTheme {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
            ) {

                Row(
                    modifier = Modifier
                        .padding(start = 2.dp, top = 8.dp)
                        .fillMaxWidth()
                ) {
                    IconButton(onClick = { navController?.popBackStack() }) {
                        Icon(
                            Icons.Rounded.ArrowBack,
                            contentDescription = context.getString(R.string.icon_button_description)
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(top = 18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = context.getString(R.string.welcome_back_to_tuj_maj)
                    )

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp),
                        value = userEmail,
                        label = { Text(text = context.getString(R.string.label_email_address)) },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        colors = if (isSystemInDarkTheme()) DarkTextFieldColor() else LightTextFieldColor(),
                        onValueChange = { it ->
                            userEmail = it
                        }
                    )

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp),
                        value = userPassword,
                        onValueChange = { userPassword = it },
                        colors = if (isSystemInDarkTheme()) DarkTextFieldColor() else LightTextFieldColor(),
                        label = {
                            Text(text = context.getString(R.string.label_password))
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        trailingIcon = {
                            val image = if (passwordVisibility)
                                Icons.Filled.Visibility
                            else Icons.Filled.VisibilityOff
                            IconButton(onClick = {
                                passwordVisibility = !passwordVisibility
                            }) {
                                Icon(image, contentDescription = "showHide")
                            }
                        },
                        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()
                    )

                    Button(
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp,
                            pressedElevation = 0.dp
                        ), onClick = { onUserLogin(userEmail.text) },
                        modifier = Modifier
                            .padding(top = 28.dp)
                    ) {
                        Text(text = context.getString(R.string.label_signin))
                    }
                    Text(
                        modifier = Modifier
                            .padding(top = 25.dp),
                        text = context.getString(R.string.forgot_password_label)
                    )
                }
            }
        }
    }
}

fun onUserLogin(text: String) {
    Log.e("User Email=>", text)
}



