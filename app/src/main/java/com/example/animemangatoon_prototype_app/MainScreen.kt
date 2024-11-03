package com.example.animemangatoon_prototype_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animemangatoon_prototype_app.model.Manga
import kotlinx.coroutines.launch


@Composable
fun MainScreen(mangaList: List<Manga>, onDetail: (String, String, Int) -> Unit, toSaved: () -> Unit) {
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(start = 10.dp, end = 26.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.animemangatoon),
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .clickable {
                        coroutineScope.launch {
                            listState.animateScrollToItem(0)
                        }
                    }
            )
            Row {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        isExpanded = true
                    }
                )
                DropdownMenu(
                    expanded = isExpanded,
                    onDismissRequest = { isExpanded = false },
                ) {
                    DropdownMenuItem(text = { Text(text = "Saved", modifier = Modifier.padding(start = 8.dp)) }, onClick = {
                        toSaved()
                        isExpanded = false
                    })
                    DropdownMenuItem(
                        text = { Text(text = "Exit", modifier = Modifier.padding(start = 8.dp)) },
                        onClick = {
                            System.exit(0)
                            isExpanded = false
                        },
                    )
                }
            }

        }

        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, bottom = 26.dp)
        ) {
            items(mangaList) { manga ->
                MangaItem(manga = manga) {
                    onDetail(
                        manga.title,
                        manga.description,
                        manga.coverResId
                    )
                }
            }
        }
    }
}

@Composable
fun MangaItem(manga: Manga, next: () -> Unit) {
    Column(
        modifier = Modifier.padding(top = 20.dp)
    ) {
        Card(
            onClick = { next() },
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        ) {
            Image(
                painter = painterResource(id = manga.coverResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Text(
                text = manga.title,
                fontSize = 20.sp,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp, bottom = 4.dp, end = 4.dp)
            )
            Text(
                text = manga.short,
                fontSize = 10.sp,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}