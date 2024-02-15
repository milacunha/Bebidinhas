package com.camilacunha.bebidinhas.model

data class DrinksListPresentation(
    val drinkInfoPresentation: List<DrinkInfoPresentation> = emptyList()
)

data class DrinkInfoPresentation(
    val idDrink: String = "",
    val strDrink: String = "",
    val ingredient: List<Pair<String, String>> = emptyList(),
    val instructions: String = "",
    val strDrinkThumb: String = "",
    val strGlass: String = "",
)