package com.tujhe_majhe.splitwisejetpack.presentation.ui

sealed class Screens(val route: String) {
    object SplashScreen : Screens("splash_screen")
    object AuthScreen : Screens("auth_screen")
    object SignInScreen : Screens("signin_screen")
    object SignUpScreen : Screens("signup_screen")
}