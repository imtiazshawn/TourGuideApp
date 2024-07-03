package com.example.travelapp.navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.travelapp.R

sealed class Screen(val route: String, val icon: ImageVector, val resourceId: Int) {
    object Home : Screen("home", Icons.Default.Home, R.string.home)
    object Search : Screen("search", Icons.Default.Search, R.string.search)
    object Favourite : Screen("favourite", Icons.Default.Favorite, R.string.favourite)
    object Profile : Screen("profile", Icons.Default.Person, R.string.profile)
}