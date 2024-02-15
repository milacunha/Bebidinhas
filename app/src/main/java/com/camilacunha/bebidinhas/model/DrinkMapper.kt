package com.camilacunha.bebidinhas.model

import com.camilacunha.bebidinhas.data.model.DrinkInfoResponse
import com.camilacunha.bebidinhas.data.model.DrinksListResponse

object DrinkMapper {
    fun turnIntoDrinksList(drinksListResponse: DrinksListResponse): DrinksListPresentation {

        val drinksMutableList = mutableListOf<DrinkInfoPresentation>()

        drinksListResponse.drinkInfoResponses?.forEach {
            drinksMutableList.add(turnIntoDrinkInfo(it))
        }

        return DrinksListPresentation(
            drinkInfoPresentation = drinksMutableList
        )
    }

    private fun turnIntoDrinkInfo(drinkInfoResponse: DrinkInfoResponse): DrinkInfoPresentation {
        return DrinkInfoPresentation(
            idDrink = drinkInfoResponse.idDrink.orEmpty(),
            strDrink = drinkInfoResponse.strDrink.orEmpty(),
            ingredient = listOf(
                Pair(drinkInfoResponse.strMeasure1.orEmpty(), drinkInfoResponse.strIngredient1.orEmpty()),
                Pair(drinkInfoResponse.strMeasure2.orEmpty(), drinkInfoResponse.strIngredient2.orEmpty()),
                Pair(drinkInfoResponse.strMeasure3.orEmpty(), drinkInfoResponse.strIngredient3.orEmpty()),
                Pair(drinkInfoResponse.strMeasure4.orEmpty(), drinkInfoResponse.strIngredient4.orEmpty()),
                Pair(drinkInfoResponse.strMeasure5.orEmpty(), drinkInfoResponse.strIngredient5.orEmpty()),
                Pair(drinkInfoResponse.strMeasure6.orEmpty(), drinkInfoResponse.strIngredient6.orEmpty()),
                Pair(drinkInfoResponse.strMeasure7.orEmpty(), drinkInfoResponse.strIngredient7.orEmpty()),
                Pair(drinkInfoResponse.strMeasure8.orEmpty(), drinkInfoResponse.strIngredient8.orEmpty()),
                Pair(drinkInfoResponse.strMeasure9.orEmpty(), drinkInfoResponse.strIngredient9.orEmpty()),
                Pair(drinkInfoResponse.strMeasure10.orEmpty(), drinkInfoResponse.strIngredient10.orEmpty()),
                Pair(drinkInfoResponse.strMeasure11.orEmpty(), drinkInfoResponse.strIngredient11.orEmpty()),
                Pair(drinkInfoResponse.strMeasure12.orEmpty(), drinkInfoResponse.strIngredient12.orEmpty()),
                Pair(drinkInfoResponse.strMeasure13.orEmpty(), drinkInfoResponse.strIngredient13.orEmpty()),
                Pair(drinkInfoResponse.strMeasure14.orEmpty(), drinkInfoResponse.strIngredient14.orEmpty()),
                Pair(drinkInfoResponse.strMeasure15.orEmpty(), drinkInfoResponse.strIngredient15.orEmpty()),
            ),
            instructions = drinkInfoResponse.strInstructions.orEmpty(),
            strDrinkThumb = drinkInfoResponse.strDrinkThumb.orEmpty(),
            strGlass = drinkInfoResponse.strGlass.orEmpty(),
        )
    }
}