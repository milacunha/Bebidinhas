package com.camilacunha.bebidinhas.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.gson.gson

object NetworkUtils {
    private const val BASE_PATH: String = "https://www.thecocktaildb.com/api/json/v1/1/"

    private val ktor = HttpClient(OkHttp) {
        defaultRequest {
            url(BASE_PATH)
        }
        install(ContentNegotiation) {
            gson()
        }
    }

    val drinkApiKtor: DrinksApiImpl = DrinksApiImpl(ktor)
}