package com.example.travelapp.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
        composable(
            "${Routes.PLACE_DETAILS_SCREEN}/{place}/{location}/{rating}/{imageResId}",
            arguments = listOf(
                navArgument("place") { type = NavType.StringType },
                navArgument("location") { type = NavType.StringType },
                navArgument("rating") { type = NavType.StringType },
                navArgument("imageResId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val place = backStackEntry.arguments?.getString("place")
            val location = backStackEntry.arguments?.getString("location")
            val rating = backStackEntry.arguments?.getString("rating")
            val imageResId = backStackEntry.arguments?.getInt("imageResId")
            PlaceDetailsScreen(place, location, rating, imageResId, navController)
        }
    }
}
