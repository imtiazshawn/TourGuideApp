package com.example.travelapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.R
import com.example.travelapp.navigations.Routes
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF0172B2), Color(0xFF001645)),
        startY = 0f,
        endY = Float.POSITIVE_INFINITY
    )

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = false

    LaunchedEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(
            color = Color(0xFF0172B2),
            darkIcons = useDarkIcons
        )
    }

    LaunchedEffect(Unit) {
        delay(3000L)
        navController.navigate(Routes.MAIN_SCREEN)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Travel",
                    color = Color.White,
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_globe),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Find Your Dream",
                    color = Color.White,
                    fontSize = 24.sp
                )
                Text(
                    text = "Destination With Us",
                    color = Color.White,
                    fontSize = 24.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}
