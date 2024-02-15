package com.camilacunha.bebidinhas.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.camilacunha.bebidinhas.R
import com.camilacunha.bebidinhas.ui.component.ImageBackground
import com.camilacunha.bebidinhas.ui.component.SearchBar
import com.camilacunha.bebidinhas.ui.component.TextFormatTitle
import com.camilacunha.bebidinhas.ui.theme.BebidinhasTheme

@Composable
fun HomeScreen(
    onClickSearch: (String) -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    val letters = CharRange('A', 'Z').toMutableList()
    val numbers = CharRange('0', '9').toMutableList()

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
                        .padding(top = 12.dp, bottom = 8.dp),
                )

                SearchBar(alphabets = letters, onClickSearch = onClickSearch)
                SearchBar(alphabets = numbers, onClickSearch = onClickSearch)

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