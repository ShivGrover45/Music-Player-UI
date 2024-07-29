package com.example.musicplayer

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun MainView(){

    Scaffold(
        topBar = { TopBar()}
    ) {
        Text(text = "Shikha", modifier = Modifier.padding(it))
    }

}