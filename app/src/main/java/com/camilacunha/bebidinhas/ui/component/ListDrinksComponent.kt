package com.camilacunha.bebidinhas.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.camilacunha.bebidinhas.model.DrinksListPresentation
import com.camilacunha.bebidinhas.ui.theme.BebidinhasTheme

@Composable
fun ListDrinksComponent(
    onRecipeClick: (Int) -> Unit,
    listDrink: DrinksListPresentation
) {
    BebidinhasTheme {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .padding(all = 8.dp)
        ) {
            items(listDrink.drinkInfoPresentation.size) {
                AsyncImage(
                    model = listDrink.drinkInfoPresentation[it].strDrinkThumb,
                    contentDescription = "drink",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(all = 8.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .clickable {
                            onRecipeClick.invoke(it)
                        }
                )
            }
        }
    }
}

@Preview
@Composable
private fun ListRecipesContentPreview() {
    ListDrinksComponent(
        onRecipeClick = {},
        listDrink = DrinksListPresentation()
    )
}