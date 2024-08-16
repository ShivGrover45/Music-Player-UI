package com.example.musicplayer

import androidx.annotation.DrawableRes

data class Lib(@DrawableRes val icons:Int,val name:String)

val libraries= listOf<Lib>(
    Lib(R.drawable.ic_microphone,"Artists"),
    Lib(R.drawable.ic_genre,"genre"),
    Lib(R.drawable.ic_playlist_green,"playlist"),
    Lib(R.drawable.baseline_music_note_24,"Songs"),
    Lib(R.drawable.baseline_album_24,"Album")
)
