package com.example.animemangatoon_prototype_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.animemangatoon_prototype_app.ui.theme.AnimeMangaToonPrototypeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeMangaToonPrototypeAppTheme {
                MangaApp()
            }
        }
    }
}

