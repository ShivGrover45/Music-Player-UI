import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.musicplayer.R
import com.example.musicplayer.Screen
import com.example.musicplayer.Screen.DrawerScreen.AddAccount.screensInDrawer
import kotlinx.coroutines.launch

@Composable
fun MainView(){

    val scope= rememberCoroutineScope()
    val scaffoldState= rememberScaffoldState()
    val controller = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute=navBackStackEntry?.destination?.route
    val title= remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Home", color = Color.White)},
                elevation = 3.dp,
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/
                    //opening the drawer menu

                        scope.launch {
                            scaffoldState.drawerState.open()
                        }

                    }) {
                        Icon(imageVector = Icons.Default.AccountCircle, contentDescription ="Account"
                        )
                    }
                }
                , contentColor = Color.White,
                backgroundColor = colorResource(id = R.color.top_bar_color),
                modifier = Modifier.height(96.dp)
                )
        },
        scaffoldState = scaffoldState
        , drawerContent = {
           LazyColumn(modifier = Modifier.padding(16.dp)) {
               items(screensInDrawer){
                   item ->
                   DrawerItem(selected = currentRoute==item.dRoute, item =item ) {

                       scope.launch {
                           scaffoldState.drawerState.close()
                       }

                       if(item.dRoute=="add"){
                           //Open add account dialog box
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
        Text(text = "Shikha", modifier = Modifier
            .fillMaxWidth()
            .padding(it))
    }

}


@Composable
fun DrawerItem(
    selected:Boolean,
    item:Screen.DrawerScreen,
    onDrawerItemClicked:()->Unit,

){
    val background=if (selected) Color.DarkGray else Color.Transparent
    Row(modifier = Modifier
        .fillMaxHeight()
        .clickable { onDrawerItemClicked() }
        .padding(
            horizontal = 8.dp, vertical = 16.dp
        )
        .background(background)) {

        Icon(painter = painterResource(id = item.icons), contentDescription =item.dTitle,
            Modifier.padding(top=4.dp, end = 8.dp)
            )

        Text(text = item.dTitle, style = MaterialTheme.typography.h5)

    }


}

@Composable
fun Navigation()
{

}