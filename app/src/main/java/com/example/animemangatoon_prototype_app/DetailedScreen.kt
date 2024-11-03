package com.example.animemangatoon_prototype_app

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(title: String, description: String, coverResId: Int) {
    val scrollState = rememberScrollState()
    var isSaved by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()

    ) {
        Image(
            painter = painterResource(id = coverResId),
            contentDescription = description,
            modifier = Modifier
                .fillMaxWidth()
                .height(270.dp)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 14.dp)
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .verticalScroll(scrollState)
                .weight(1f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        val context = LocalContext.current
        AssistChip(
            onClick = {
                isSaved = !isSaved
                if (isSaved) Toast.makeText(context, "Saved Successfully!", Toast.LENGTH_SHORT).show() else Toast.makeText(context, "Removed Successfully!", Toast.LENGTH_SHORT).show()
            },
            label = {
                Icon(
                    imageVector = if (isSaved) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    tint = if (isSaved) Color.Red else Color.Gray
                )
            }
        )
    }
}