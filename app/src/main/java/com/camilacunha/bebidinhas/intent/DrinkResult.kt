package com.camilacunha.bebidinhas.intent

import com.camilacunha.bebidinhas.data.model.DrinksListResponse

sealed class DrinkResult {
    object Loading : DrinkResult()
    data class Success(val list: DrinksListResponse) : DrinkResult()
    data class Failure(val message: String) : DrinkResult()
}