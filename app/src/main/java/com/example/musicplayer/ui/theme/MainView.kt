package com.example.musicplayer.ui.theme


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.musicplayer.MainViewModel
import com.example.musicplayer.R
import com.example.musicplayer.Screen
import com.example.musicplayer.screensInBottom
import com.example.musicplayer.screensInDrawer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(){
    Surface(modifier = Modifier.background(MaterialTheme.colors.onBackground)) {
        val scaffoldState:ScaffoldState = rememberScaffoldState()
        val scope :CoroutineScope= rememberCoroutineScope()
        val viewModel: MainViewModel = viewModel()
        val controller:NavController = rememberNavController()
        val navBackStackEntry by controller.currentBackStackEntryAsState()
        val currentRoute=navBackStackEntry?.destination?.route
        val dialogOpen= remember {
            mutableStateOf(false)
        }
        val currentScreen= remember {
            viewModel.currentScreen.value
        }
        val title= remember {
            mutableStateOf(currentScreen.title)
        }
        val bottomBar:@Composable () -> Unit={
            if(currentScreen is Screen.DrawerScreen || currentScreen==Screen.BottomScreen.Home){
               BottomNavigation(
                   modifier = Modifier
                       .wrapContentSize()
                       .heightIn(min = 94.dp),
                   backgroundColor = colorResource(id = R.color.top_bar_color)
               ) {
                   screensInBottom.forEach{
                       item->BottomNavigationItem(
                       selected = currentRoute==item.bRoute,
                       onClick = {controller.navigate(item.bRoute)},
                       icon = { Icon(painter = painterResource(id = item.icons),
                           contentDescription =item.bTitle )}
                       , label = { Text(text = item.bTitle)}
                           , selectedContentColor = Color.White,
                           unselectedContentColor = Color.Black
                           )
                   }
               }
            }
    }

        Scaffold(
            bottomBar = bottomBar,
            topBar = {
                TopAppBar(title = {
                    Text(text = title.value)
                },
                    navigationIcon = { IconButton(onClick = {
                        // Open the drawer
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Menu"
                        )
                    }}
                    , colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = colorResource(id =R.color.top_bar_color ))
                )

            },
            scaffoldState = scaffoldState,
            drawerContent = {
                LazyColumn(Modifier.padding(16.dp)) {
                    items(screensInDrawer){
                            item ->
                        DrawerItem(selected = currentRoute==item.dRoute, item =item ) {
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                            if(item.dRoute=="add"){
                                //Open add account dialog box
                                dialogOpen.value=true
                            }
                            else{
                                controller.navigate(item.dRoute)
                                title.value=item.dTitle
                            }
                        }
                    }
                }
            }
        ) {
            Navigation(navController= controller, viewModel =viewModel , pd =it )
            AccountDialog(dialogOpen = dialogOpen)
        }

    }
    }



@Composable
fun DrawerItem(
    selected:Boolean,
    item:Screen.DrawerScreen,
    onDrawerItemClicked:()->Unit,

){
    val background=if (selected) Color.DarkGray else Color.White
    Row(Modifier
        .fillMaxHeight()
        .clickable { onDrawerItemClicked() }
        .padding(
            horizontal = 8.dp, vertical = 16.dp
        )
        .background(background)) {

        Icon(painter = painterResource(id = item.icons), contentDescription =item.dTitle,
            Modifier.padding(end = 8.dp, top = 4.dp)
            )

        Text(text = item.dTitle,
            style = MaterialTheme.typography.h5,)

    }
}

@Composable
fun Navigation(navController: NavController, viewModel: MainViewModel, pd:PaddingValues){

    NavHost(navController = navController as NavHostController,
        startDestination =Screen.DrawerScreen.Account.route ,
        modifier = Modifier.padding(pd)
        ) {

        composable(Screen.BottomScreen.Home.bRoute){
            HomeView()
        }

        composable(Screen.BottomScreen.Browse.bRoute){
            // TODO Add Browse Screen
            BrowseScreen()
        }

        composable(Screen.BottomScreen.Library.bRoute){
            //TODO Add Library Screen
        }

        composable(Screen.DrawerScreen.Account.route){
            AccountView()
        }
        composable(Screen.DrawerScreen.Subscription.route){
            SubscriptionView()
        }
    }

}
