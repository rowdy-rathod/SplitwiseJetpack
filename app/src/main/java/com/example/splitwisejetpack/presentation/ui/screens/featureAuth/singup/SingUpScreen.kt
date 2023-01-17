package com.example.splitwisejetpack.presentation.ui.screens.featureAuth.singup

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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.splitwisejetpack.R
import com.example.splitwisejetpack.presentation.theme.DarkTextFieldColor
import com.example.splitwisejetpack.presentation.theme.LightTextFieldColor
import com.example.splitwisejetpack.presentation.theme.SplitwiseTheme

@Preview(showBackground = true)
@Composable
fun SignUpScreen(navController: NavController? = null) {

    var userFullName by remember { mutableStateOf("") }

    var userEmail by remember { mutableStateOf("") }

    var userPassword by remember { mutableStateOf("") }

    var userPhoneNumber by remember { mutableStateOf("") }

    var userSTDCode by remember { mutableStateOf("") }

    var passwordVisibility by remember { mutableStateOf(false) }

    val context = LocalContext.current

    SplitwiseTheme {
        Surface {
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
                        value = userFullName,
                        onValueChange = { userFullName = it },
                        colors = if (isSystemInDarkTheme()) DarkTextFieldColor() else LightTextFieldColor(),
                        label = { Text(text = context.getString(R.string.label_fullname)) },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp)
                    ) {
                        ImagePickerForSignUp()
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 12.dp)
                        ) {
                            TextField(
                                modifier = Modifier
                                    .padding(top = 12.dp),
                                value = userEmail,
                                onValueChange = { userEmail = it },
                                colors = if (isSystemInDarkTheme()) DarkTextFieldColor() else LightTextFieldColor(),
                                label = {
                                    Text(text = context.getString(R.string.label_email_address))
                                },
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Email,
                                    imeAction = ImeAction.Next
                                )

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
                                    imeAction = ImeAction.Next
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
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        TextField(
                            modifier = Modifier
                                .width(80.dp)
                                .padding(top = 12.dp),
                            value = userSTDCode,
                            onValueChange = { userSTDCode == it },
                            colors = if (isSystemInDarkTheme()) DarkTextFieldColor() else LightTextFieldColor(),
                            label = {
                                Text(text = "+91")
                            },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            )

                        )
                        TextField(
                            modifier = Modifier
                                .padding(top = 12.dp, start = 12.dp),
                            value = userPhoneNumber,
                            onValueChange = { userPhoneNumber = it },
                            colors = if (isSystemInDarkTheme()) DarkTextFieldColor() else LightTextFieldColor(),
                            label = {
                                Text(text = context.getString(R.string.label_phone))
                            },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            )

                        )

                    }

                    Row(
                        modifier = Modifier
                            .padding(top = 25.dp),
                    ) {
                        Text(
                            text = context.getString(R.string.label_use_currency, "INR")
                        )
                        Text(
                            modifier = Modifier
                                .padding(start = 8.dp),
                            text = context.getString(R.string.label_change),
                            color = MaterialTheme.colors.onBackground
                        )
                    }

                    Button(
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp,
                            pressedElevation = 0.dp
                        ), onClick = { },
                        modifier = Modifier
                            .padding(top = 28.dp)
                    ) {
                        Text(text = context.getString(R.string.label_done))
                    }

                }

            }
        }
    }
}
