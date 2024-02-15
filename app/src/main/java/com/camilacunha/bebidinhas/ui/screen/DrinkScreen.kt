package com.camilacunha.bebidinhas.ui.screen

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.camilacunha.bebidinhas.R
import com.camilacunha.bebidinhas.model.DrinkInfoPresentation
import com.camilacunha.bebidinhas.ui.component.ImageBackground
import com.camilacunha.bebidinhas.ui.component.TextFormatTitle
import com.camilacunha.bebidinhas.ui.component.TextInformationDetails
import com.camilacunha.bebidinhas.ui.component.TextInformationTitle
import com.camilacunha.bebidinhas.ui.theme.BebidinhasTheme

@Composable
fun DrinkScreen(
    onClickBack: () -> Unit,
    drinkInfoPresentation: DrinkInfoPresentation
) {
    val listPrep = drinkInfoPresentation.instructions.split(".")

    BebidinhasTheme {
        Box(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(colorResource(id = R.color.white)),
        ) {
            ImageBackground()
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Icon(
                        imageVector = Icons.Outlined.KeyboardArrowLeft,
                        contentDescription = "back",
                        tint = colorResource(id = R.color.main_red),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable { onClickBack() }
                    )
                    TextFormatTitle(
                        text = drinkInfoPresentation.strDrink,
                        lineHeight = 20.sp,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .wrapContentSize()
                            .weight(0.5f)
                    )
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = "favorite",
                        tint = colorResource(id = R.color.main_red),
                        modifier = Modifier.wrapContentSize()
                    )
                }
                AsyncImage(
                    model = drinkInfoPresentation.strDrinkThumb,
                    contentDescription = "drink",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp),
                    contentScale = ContentScale.FillWidth
                )
                TextInformationTitle(
                    text = stringResource(R.string.ingredients),
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(top = 24.dp, start = 12.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 24.dp)
                        .padding(top = 12.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.food),
                        contentDescription = "image",
                        colorFilter = ColorFilter.tint(colorResource(id = R.color.main_red)),
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(8.dp)
                            .height(46.dp)
                            .width(46.dp)
                    )
                    Column {
                        drinkInfoPresentation.ingredient.forEach {
                            if (it.first.isNotEmpty() && it.second.isNotEmpty()) {
                                TextInformationDetails(
                                    text = it.first + " - " + it.second,
                                    modifier = Modifier
                                        .wrapContentSize()
                                        .padding(start = 8.dp)
                                )
                            }
                        }
                    }
                }
                TextInformationTitle(
                    text = stringResource(R.string.kitchenware),
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(top = 16.dp, start = 12.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 24.dp)
                        .padding(top = 12.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bake),
                        contentDescription = "image",
                        colorFilter = ColorFilter.tint(colorResource(id = R.color.main_red)),
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(8.dp)
                            .height(46.dp)
                            .width(46.dp)
                    )
                    Column {
                        TextInformationDetails(
                            text = drinkInfoPresentation.strGlass,
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(start = 8.dp)
                        )
                    }
                }
                TextInformationTitle(
                    text = stringResource(R.string.prep_mode),
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 12.dp, top = 16.dp, bottom = 12.dp)
                )
                listPrep.forEachIndexed { index, prep ->
                    if (prep.isNotBlank()) {
                        TextInformationDetails(
                            text = "${index + 1} - $prep",
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(top = 4.dp)
                                .padding(horizontal = 24.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun DrinkScreenPreview() {
    DrinkScreen(
        onClickBack = {},
        drinkInfoPresentation = DrinkInfoPresentation(
            idDrink = "1",
            strDrink = "Drink de Morango",
            ingredient = listOf(
                Pair("1 xícara", "vodka"),
                Pair("2 xícaras", "morango"),
                Pair("A gosto", "gelo")
            ),
            instructions = "Corte os morangos bem pequenos. Misture os morangos com a vodka. Acrescente gelo se quiser.",
            strDrinkThumb = "",
            strGlass = "Copo grande",
        )
    )
}