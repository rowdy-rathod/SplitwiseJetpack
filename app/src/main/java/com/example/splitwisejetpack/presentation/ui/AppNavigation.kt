package com.example.splitwisejetpack.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.splitwisejetpack.presentation.ui.screens.featureAuth.Auth
import com.example.splitwisejetpack.presentation.ui.screens.featureAuth.signin.SignInScreen
import com.example.splitwisejetpack.presentation.ui.screens.featureAuth.singup.SignUpScreen
import com.example.splitwisejetpack.presentation.ui.screens.featureSplash.SplashScreen

@Composable
fun AppNavigationController() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route
    ) {
        composable(route = Screens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = Screens.AuthScreen.route) {
            Auth(navController = navController)
        }

        composable(route = Screens.SignUpScreen.route) {
            SignUpScreen(navController)
        }

        composable(route = Screens.SignInScreen.route) {
            SignInScreen(navController)
        }
    }


}
