package com.camilacunha.bebidinhas.intent

import com.camilacunha.bebidinhas.model.DrinkInfoPresentation
import com.camilacunha.bebidinhas.model.DrinksListPresentation

sealed class DrinkState {
    object Loading : DrinkState()
    data class ListDrinkSuccess(val drinkList: DrinksListPresentation) : DrinkState()
    data class OneDrinkSuccess(val oneDrink: DrinkInfoPresentation) : DrinkState()
    data class Error(val message: String?) : DrinkState()
}
