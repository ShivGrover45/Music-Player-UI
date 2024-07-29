package com.example.musicplayer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){

    val scaffoldState:ScaffoldState= rememberScaffoldState()
    val scope:CoroutineScope= rememberCoroutineScope()

    TopAppBar(title = { Text(text = "Home") }
    ,
        navigationIcon = {
            IconButton(onClick = {
                /*
            Opening the account bar menu
            */

                scope.launch {
                    scaffoldState.drawerState.open(

                    )
                }

            }) {
                Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "Accounts")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.top_bar_color)
            , titleContentColor = Color.White
            , navigationIconContentColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 4.dp)
        )
}