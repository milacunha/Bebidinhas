package com.camilacunha.bebidinhas.ui.screen

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.camilacunha.bebidinhas.R
import com.camilacunha.bebidinhas.model.BottomIconsPresentation
import com.camilacunha.bebidinhas.ui.component.ImageBackground
import com.camilacunha.bebidinhas.ui.component.TextSearch
import com.camilacunha.bebidinhas.ui.component.TextFormatTitle
import com.camilacunha.bebidinhas.ui.theme.BebidinhasTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(
    bottomMenu: List<BottomIconsPresentation>,
    showSearchBar: MutableState<Boolean>,
    onClickSearch: (String) -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    val inputSearch = remember { mutableStateOf("") }
    var rowSize by remember { mutableStateOf(Size.Zero) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val onSearch: (String) -> Unit = {
        keyboardController?.hide()
        onClickSearch(inputSearch.value)
    }

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
                AnimatedVisibility(visible = showSearchBar.value) {
                    TextField(
                        value = inputSearch.value,
                        onValueChange = { inputSearch.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                            .padding(horizontal = 16.dp),
                        placeholder = { TextSearch(text = "Buscar Receita") },
                        textStyle = TextStyle(
                            fontFamily = FontFamily(
                                Font(R.font.sourcesans, FontWeight.Normal)
                            ),
                            letterSpacing = (-0.24).sp,
                            lineHeight = 20.sp,
                            fontSize = 18.sp,
                            color = colorResource(id = R.color.white),
                        ),
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Search,
                                contentDescription = "search",
                                tint = colorResource(id = R.color.white),
                                modifier = Modifier.clickable { onSearch(inputSearch.value) }
                            )
                        },
                        shape = RoundedCornerShape(22.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            focusedTextColor = Color.White,
                            containerColor = colorResource(id = R.color.main_red),
                            cursorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        ),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                        keyboardActions = KeyboardActions(
                            onSearch = { onSearch(inputSearch.value) })
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.5f)
                ) {
                    content()
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(colorResource(id = R.color.main_red))
                        .onGloballyPositioned {
                            rowSize = it.size.toSize()
                        },
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    val maxWidth = LocalDensity.current.run {
                        (rowSize.width / 5).toDp()
                    }
                    LazyRow {
                        items(bottomMenu.size) {
                            Box(
                                modifier = Modifier
                                    .height(60.dp)
                                    .width(maxWidth)
                                    .clip(RectangleShape)
                                    .background(colorResource(id = R.color.main_red))
                                    .clickable { bottomMenu[it].action.invoke() },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = bottomMenu[it].icon,
                                    contentDescription = "icon",
                                    tint = colorResource(id = R.color.white),
                                    modifier = Modifier.wrapContentSize()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun HomeScreenPreview() {
    val showSearchBar = remember { mutableStateOf(false) }
    HomeScreen(
        bottomMenu = emptyList(),
        showSearchBar = showSearchBar,
    )
}