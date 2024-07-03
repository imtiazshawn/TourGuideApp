package com.example.travelapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.R
import com.example.travelapp.navigations.Routes

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column {
                Text(text = "Hey David,", fontSize = 24.sp, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Explore the World!", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.man),
                contentDescription = "DP",
                modifier = Modifier
                    .size(50.dp)
                    .clip(shape = RoundedCornerShape(200.dp))
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .border(
                    BorderStroke(1.dp, color = Color(0xFFCCCCCC)),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 16.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = "Search the place...",
                onValueChange = { },
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 16.dp),
                textStyle = TextStyle(color = Color.Black)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Popular Places", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "View All", fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            )
            {
                Text(text = "Most Viewed", modifier = Modifier.padding(vertical = 6.dp))
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
            )
            {
                Text(text = "Nearby", modifier = Modifier.padding(vertical = 6.dp))
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
            )
            {
                Text(text = "Latest", modifier = Modifier.padding(vertical = 6.dp))
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow {
            val dummyImageResIds = listOf(
                R.drawable.nature,
                R.drawable.nature,
                R.drawable.nature
            )
            items(dummyImageResIds) { imageResId ->
                ImageCard(imageResId = imageResId, navController = navController)
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}


@Composable
private fun ImageCard(imageResId: Int = android.R.drawable.ic_menu_gallery, navController: NavHostController) {
    Box(
        modifier = Modifier
            .width(300.dp)
            .height(400.dp)
            .clip(shape = RoundedCornerShape(15.dp))
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(alpha = 0.8f)
                .clickable {
                    navController.navigate(Routes.PLACE_DETAILS_SCREEN)
                }
        )
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = Color.Black.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(24.dp)
                    )
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .align(Alignment.BottomCenter)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = Color.Black.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(4.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Column(
                    modifier = Modifier
                        .width(250.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(
                            text = "Mount Fuji,",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(
                            text = "Tokyo",
                            color = Color.White,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = null,
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Tokyo",
                                color = Color.LightGray,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(end = 8.dp)
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "4.5",
                                color = Color.White,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(end = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}