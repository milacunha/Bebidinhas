package com.camilacunha.bebidinhas.intent

sealed class DrinkIntent {
    object LoadDrinks : DrinkIntent()
    object HomeDrinks : DrinkIntent()
    data class SearchDrinks(val name: String) : DrinkIntent()
    data class LoadOneDrink(val drink: Int) : DrinkIntent()
}
