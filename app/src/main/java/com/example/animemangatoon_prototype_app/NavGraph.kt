package com.example.animemangatoon_prototype_app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animemangatoon_prototype_app.model.MangaData

@Composable
fun MangaApp() {
    val list = MangaData.mangaList
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable("MainScreen") {
            MainScreen(mangaList = list, onDetail = { title, description, coverResId ->
                navController.navigate("DetailScreen/$title/$description/$coverResId")
            }, toSaved = {
                navController.navigate("SavedScreen")
            })
        }
        composable("DetailScreen/{title}/{description}/{coverResId}") { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val description = backStackEntry.arguments?.getString("description") ?: ""
            val coverResId = backStackEntry.arguments?.getString("coverResId")?.toInt() ?: R.drawable.ic_launcher_background
            DetailScreen(title, description, coverResId)
        }
        composable("SavedScreen"){
            SavedScreen()
        }
    }
}