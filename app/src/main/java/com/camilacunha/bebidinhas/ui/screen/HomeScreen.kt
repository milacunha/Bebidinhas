package com.camilacunha.bebidinhas.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.camilacunha.bebidinhas.R
import com.camilacunha.bebidinhas.ui.component.ImageBackground
import com.camilacunha.bebidinhas.ui.component.TextFormatTitle
import com.camilacunha.bebidinhas.ui.component.TextSearch
import com.camilacunha.bebidinhas.ui.theme.BebidinhasTheme

@Composable
fun HomeScreen(
    onClickSearch: (String) -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    val alphabets = CharRange('A', 'Z').toMutableList()
    var rowSize by remember { mutableStateOf(Size.Zero) }

    BebidinhasTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.white)),
        ) {
            ImageBackground()
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                TextFormatTitle(
                    text = stringResource(id = R.string.app_name),
                    lineHeight = 20.sp,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(top = 12.dp)
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

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.5f)
                ) {
                    content()
                }
            }
        }
    }
}


@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}