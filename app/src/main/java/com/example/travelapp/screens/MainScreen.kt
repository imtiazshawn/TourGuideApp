package com.example.travelapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.navigations.AppNavigationGraph
import com.example.travelapp.navigations.Screen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MainScreen(navController: NavHostController) {
    val navMainController = rememberNavController()
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = true

    LaunchedEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(
            color = Color.White,
            darkIcons = useDarkIcons
        )
    }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                val items = listOf(
                    Screen.Home,
                    Screen.Search,
                    Screen.Favourite,
                    Screen.Profile
                )
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(imageVector = screen.icon, contentDescription = null) },
                        selected = false,
                        onClick = {
                            navMainController.navigate(screen.route) {
                                popUpTo(navMainController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            AppNavigationGraph(navMainController = navMainController, navController = navController)
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
//    MainScreen(rememberNavController())
}
