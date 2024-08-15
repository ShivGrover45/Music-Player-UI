package com.example.musicplayer.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.musicplayer.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeView(){
    val categories= listOf("Rap","romantic","workout","Phonk","soothing")
    val grouped= listOf<String>("Top Rated","Favorites","New Releases").groupBy {
        it[0]
    }
    LazyColumn {
        grouped.forEach{
            stickyHeader {
                Text(text = it.value[0], modifier = Modifier.padding(16.dp), color = Color.Black)
                LazyRow {
                    items(categories){
                       cat->
                        BrowserItem(cat, R.drawable.baseline_library_music_24)
                    }
                }
            }
        }
    }
}
@Composable
fun BrowserItem(categories:String,drawable:Int){
    Card(
        modifier = Modifier
            .padding(16.dp)
            .size(200.dp), border = BorderStroke(3.dp, Color.DarkGray)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = categories)
            Image(painter = painterResource(id = drawable), contentDescription = categories)
        }
    }
}