package com.camilacunha.bebidinhas.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.camilacunha.bebidinhas.R

@Composable
fun SearchBar(
    alphabets: MutableList<Char>,
    onClickSearch: (String) -> Unit
){
    var rowSize by remember { mutableStateOf(Size.Zero) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(top = 4.dp)
            .background(colorResource(id = R.color.main_red))
            .onGloballyPositioned {
                rowSize = it.size.toSize()
            },
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val maxWidth = LocalDensity.current.run {
            (rowSize.width / 10).toDp()
        }
        LazyRow {
            items(alphabets.size) {
                Box(
                    modifier = Modifier
                        .height(60.dp)
                        .width(maxWidth)
                        .clip(RectangleShape)
                        .background(colorResource(id = R.color.main_red))
                        .clickable { onClickSearch(alphabets[it].lowercase()) },
                    contentAlignment = Alignment.Center
                ) {
                    TextSearch(text = alphabets[it].uppercase())
                }
            }
        }
    }
}