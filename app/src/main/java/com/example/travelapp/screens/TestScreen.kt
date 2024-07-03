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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelapp.R

@Composable
fun TestScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column {
                Text(text = "Hi, David", fontSize = 20.sp, fontWeight = FontWeight.Medium)
                Text(text = "Explore the World", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Search Bar Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                .border(
                    BorderStroke(1.dp, color = Color(0xFFCCCCCC)),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Search",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Popular Places",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "View All",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.clickable {}
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CategoryItem(text = "Most Viewed", isSelected = true)
            CategoryItem(text = "Nearby", isSelected = false)
            CategoryItem(text = "Latest", isSelected = false)
        }
        Spacer(modifier = Modifier.height(16.dp))

        LazyRow {
            val dummyImageResIds = listOf(
                R.drawable.nature,
                R.drawable.nature,
                R.drawable.nature
            )
            items(dummyImageResIds) { imageResId ->
                ImageCard(imageResId = imageResId)
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}

@Composable
private fun CategoryItem(text: String, isSelected: Boolean) {
    val backgroundColor = if (isSelected) Color.Black else Color.Transparent
    val textColor = if (isSelected) Color.White else Color.Black
    Box(
        modifier = Modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
        )
    }
}

@Composable
private fun ImageCard(imageResId: Int = android.R.drawable.ic_menu_gallery) {
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
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .align(Alignment.BottomEnd)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = Color.White.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(4.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Location & Rating",
                        color = Color.Black,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TestScreenPreview() {
    TestScreen()
}
