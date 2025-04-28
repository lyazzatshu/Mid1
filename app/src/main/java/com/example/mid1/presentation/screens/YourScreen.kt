package com.example.mid1.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel

@Composable
fun YourScreen(
    viewModel: YourViewModel = koinViewModel()
) {
    val items by viewModel.items.collectAsState()

    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        BasicTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Button(
            onClick = {
                if (text.isNotBlank()) {
                    viewModel.addItem(text)
                    text = ""
                }
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Добавить")
        }

        Spacer(modifier = Modifier.height(16.dp))

        items.forEach { item ->
            Text(
                text = item.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )
        }
    }
}
