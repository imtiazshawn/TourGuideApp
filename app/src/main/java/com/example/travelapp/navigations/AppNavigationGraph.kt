package com.example.travelapp.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.travelapp.screens.FavouriteScreen
import com.example.travelapp.screens.HomeScreen
import com.example.travelapp.screens.ProfileScreen
import com.example.travelapp.screens.SearchScreen

@Composable
fun AppNavigationGraph(navMainController: NavHostController, navController: NavHostController) {
    NavHost(
        navController = navMainController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Search.route) { SearchScreen() }
        composable(Screen.Favourite.route) { FavouriteScreen() }
        composable(Screen.Profile.route) { ProfileScreen() }
    }
}