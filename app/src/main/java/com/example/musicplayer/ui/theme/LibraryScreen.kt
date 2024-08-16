package com.example.musicplayer.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.layout.TestModifierUpdaterLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.musicplayer.Lib
import com.example.musicplayer.R
import com.example.musicplayer.libraries


@Composable
fun LibraryScreen(){
    LazyColumn {
        items(libraries) {
            lib ->
            LibItem(lib = lib)

    }
    }
}

@Composable
fun LibItem(lib:Lib){
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row() {
                Icon(painter = painterResource(id = lib.icons), contentDescription =lib.name,
                    modifier = Modifier.padding(horizontal = 16.dp), tint = Color.DarkGray )
                Text(text = lib.name)
            }
            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription ="right arrow", tint = Color.DarkGray)
        }
        Divider(color = colorResource(id = R.color.top_bar_color))
    }
}
