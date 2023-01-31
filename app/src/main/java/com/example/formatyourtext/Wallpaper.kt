package com.example.formatyourtext

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource


@Composable
fun Wallpaper (itemId: Int) {
    Image(painter = painterResource(id = itemId),
        contentDescription = "wallpaper",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds)
}