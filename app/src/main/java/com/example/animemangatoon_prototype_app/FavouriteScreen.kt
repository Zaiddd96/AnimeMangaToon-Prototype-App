package com.example.animemangatoon_prototype_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SavedScreen(){
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hey There!" +
                    "I haven't yet implemented a favorites screen " +
                    "that uses Room Database for local storage in " +
                    "my app, but I want to highlight my ability to " +
                    "learn quickly. As I continue to expand my knowledge, " +
                    "I’m confident that once I dive into Room Database, " +
                    "I’ll be able to integrate this feature efficiently. " +
                    "My focus is on continuous learning and adapting to new " +
                    "challenges swiftly, ensuring I can enhance the app with " +
                    "robust and scalable solutions.",
            fontSize = 20.sp,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}