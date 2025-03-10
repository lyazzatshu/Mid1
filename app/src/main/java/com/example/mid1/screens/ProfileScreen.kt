package com.example.mid1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mid1.R

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.space_bg), // Добавь картинку в res/drawable
            contentDescription = "Profile Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.6f))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.avatar), // Добавь картинку аватара в res/drawable
                contentDescription = "Profile Avatar",
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Gray, shape = CircleShape)
            )

            Spacer(modifier = Modifier.height(8.dp))


            Text(
                text = "Lyazzat",
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 22.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))


            Text(
                text = "Мои посты",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.height(16.dp))


            Button(
                onClick = { /* TODO: Добавить действие */ },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBB86FC)),
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Icon(Icons.Default.Edit, contentDescription = "Edit", tint = Color.Black)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Редактировать", fontSize = 16.sp, color = Color.Black)
            }

            Spacer(modifier = Modifier.height(16.dp))


            Button(
                onClick = { /* TODO: Добавить действие */ },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Post", tint = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Добавить пост", fontSize = 16.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))


            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(postList) { post ->
                    PostCard(postText = post)
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}


@Composable
fun PostCard(postText: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(12.dp)
        ) {
            Text(text = postText, style = MaterialTheme.typography.bodyLarge, color = Color.Black)
        }
    }
}


val postList = listOf(
    "🌌 Сегодня я наблюдал за звездами...",
    "🚀 Последние новости о миссии на Марс!",
    "🔭 Как выбрать лучший телескоп для наблюдения?",
    "🪐 Мои любимые планеты и их особенности."
)
