package com.example.musicplayer.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SubscriptionView(){
    Column(
       modifier = Modifier.height(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Manage Subscription")
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Musical")
                Column() {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "Free Tier")

                        TextButton(onClick = { /*TODO*/ }) {
                            Row {
                                Text(text = "See all plans")
                                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                    contentDescription = "see all plans")
                            }
                        }
                    }

                }
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                Row(modifier = Modifier.padding(vertical = 16.dp)){
                    Icon(imageVector = Icons.Default.AccountBox, contentDescription ="Plans" )
                    Text(text = "Get a plan")
                }
            }

        }
    }
}