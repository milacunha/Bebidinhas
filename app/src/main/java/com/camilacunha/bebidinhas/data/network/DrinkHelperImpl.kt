package com.camilacunha.bebidinhas.data.network

import com.camilacunha.bebidinhas.intent.DrinkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DrinkHelperImpl(
    private val drinksApi: DrinksApi
) : DrinkHelper {

    override fun getDrinksList(): Flow<DrinkResult> = flow {
        emit(
            try {
                DrinkResult.Success(drinksApi.getDrinksListWithA())
            } catch (e: Exception) {
                DrinkResult.Failure(e.message.orEmpty())
            }
        )
    }

    override fun getDrinksListWithSearch(search: String): Flow<DrinkResult> = flow {
        emit(
            try {
                DrinkResult.Success(drinksApi.getDrinksListWithSearch(query = search))
            } catch (e: Exception) {
                DrinkResult.Failure(e.message.orEmpty())
            }
        )
    }
}