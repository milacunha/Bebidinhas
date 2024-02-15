package com.camilacunha.bebidinhas.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.camilacunha.bebidinhas.R

@Composable
fun ImageBackground() {
    Image(
        painter = painterResource(id = R.drawable.background),
        contentDescription = "background",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds,
        alpha = 0.15f
    )
}