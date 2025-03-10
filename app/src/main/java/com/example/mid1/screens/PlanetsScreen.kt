package com.example.mid1.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mid1.R
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun PlanetsScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ttt1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )


        FallingStarsAnimation()


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Анимация",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.LightGray
            )
        }
    }
}

@Composable
fun FallingStarsAnimation() {
    val stars = remember {
        List(70) {
            Star(
                startX = Random.nextFloat() * 1000f,
                startY = Random.nextFloat() * 1000f,
                speed = Random.nextFloat() * 5 + 3
            )
        }
    }

    val animatedStars = remember { mutableStateListOf(*stars.toTypedArray()) }

    LaunchedEffect(Unit) {
        while (true) {
            animatedStars.replaceAll { star ->
                star.copy(
                    startY = if (star.startY > 1500f) 0f else star.startY + star.speed
                )
            }
            delay(16L) // 60 FPS
        }
    }

    Canvas(modifier = Modifier.fillMaxSize()) {
        animatedStars.forEach { star ->
            drawCircle(
                color = Color.White,
                radius = 3f,
                center = androidx.compose.ui.geometry.Offset(star.startX, star.startY)
            )
        }
    }
}

data class Star(val startX: Float, var startY: Float, val speed: Float)
