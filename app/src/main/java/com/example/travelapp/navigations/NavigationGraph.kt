package com.example.travelapp.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.screens.*

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.SPLASH_SCREEN) {
        composable(Routes.SPLASH_SCREEN) {
            SplashScreen(navController)
        }
        composable(Routes.MAIN_SCREEN) {
            MainScreen(navController)
        }
        composable(Routes.PLACE_DETAILS_SCREEN) {
            PlaceDetailsScreen(navController)
        }
    }
}
