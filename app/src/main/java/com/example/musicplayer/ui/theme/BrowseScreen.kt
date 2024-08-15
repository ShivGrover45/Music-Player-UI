package com.example.musicplayer.ui.theme

import android.provider.FontsContract.Columns
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.provider.FontsContractCompat
import com.example.musicplayer.R

@Composable
fun BrowseScreen(){
    val categories= listOf<String>("Rap","Phonk","Soothing","classical","hip-hop","pop")
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(categories) {
            cat->
           BrowserItem(categories = cat, drawable = R.drawable.baseline_library_music_24)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun BrowsePreview(){
    BrowseScreen()
}