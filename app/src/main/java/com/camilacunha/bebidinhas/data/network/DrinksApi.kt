package com.camilacunha.bebidinhas.data.network

import com.camilacunha.bebidinhas.data.model.DrinksListResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class DrinksApi(
    private val ktor: HttpClient
) {
    suspend fun getDrinksListWithSearch(query: String): DrinksListResponse {
        return ktor.get("search.php?f=$query").body()
    }

    suspend fun getDrinksListWithA(): DrinksListResponse {
        return ktor.get("search.php?f=a").body()
    }
}