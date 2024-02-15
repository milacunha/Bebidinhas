package com.camilacunha.bebidinhas.data.network

import com.camilacunha.bebidinhas.intent.DrinkResult
import kotlinx.coroutines.flow.Flow

interface DrinkHelper {
    fun getDrinksList(): Flow<DrinkResult>
    fun getDrinksListWithSearch(search: String): Flow<DrinkResult>
}