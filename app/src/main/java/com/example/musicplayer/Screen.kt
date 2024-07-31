package com.example.musicplayer

import androidx.annotation.DrawableRes

sealed class Screen(val title:String,val route:String) {

    sealed class DrawerScreen(
        val dTitle:String,
        val dRoute:String,
        @DrawableRes val icons:Int
    ):Screen(dTitle,dRoute) {

        object Account : DrawerScreen(
            "Account",
            "account",
            R.drawable.baseline_account_circle_24
        )

         object Subscription : DrawerScreen(
            "Subscription",
            "subscribe",
            R.drawable.baseline_library_music_24
        )

        object AddAccount : DrawerScreen(
            "Add Account",
            "add",
            R.drawable.baseline_person_add_alt_24
        )
    }
}
val screensInDrawer = listOf(
            Screen.DrawerScreen.Account,
            Screen.DrawerScreen.Subscription,
            Screen.DrawerScreen.AddAccount
        )
