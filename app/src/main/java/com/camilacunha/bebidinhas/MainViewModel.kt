package com.camilacunha.bebidinhas

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.camilacunha.bebidinhas.data.network.DrinkHelperImpl
import com.camilacunha.bebidinhas.data.network.NetworkUtils
import com.camilacunha.bebidinhas.intent.BackIntent
import com.camilacunha.bebidinhas.intent.DrinkIntent
import com.camilacunha.bebidinhas.intent.DrinkResult
import com.camilacunha.bebidinhas.intent.DrinkState
import com.camilacunha.bebidinhas.model.DrinkMapper
import com.camilacunha.bebidinhas.model.DrinksListPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _state = mutableStateOf<DrinkState>(DrinkState.Loading)
    val state: State<DrinkState> = _state

    private val _intent = mutableStateOf<BackIntent>(BackIntent.FirstTouch)
    val intent: State<BackIntent> = _intent

    private val drinksApiKtor = DrinkHelperImpl(NetworkUtils.drinkApiKtor)
    private val drinksList = mutableStateOf(DrinksListPresentation())

    init {
        processIntent(DrinkIntent.HomeDrinks)
    }

    fun processIntent(intent: DrinkIntent) {
        when (intent) {
            is DrinkIntent.LoadDrinks -> loadSearch()
            is DrinkIntent.HomeDrinks -> loadDrinks()
            is DrinkIntent.LoadOneDrink -> loadingOneDrink(intent.drink)
            is DrinkIntent.SearchDrinks -> loadDrinksSearch(intent.name)
        }
    }

    private fun processResult(drinkResult: DrinkResult) {
        when (drinkResult) {
            is DrinkResult.Loading -> _state.value = DrinkState.Loading
            is DrinkResult.Success -> {
                val drinksListPresentation = DrinkMapper.turnIntoDrinksList(drinkResult.list)
                drinksList.value = drinksListPresentation
                _state.value = DrinkState.ListDrinkSuccess(drinksListPresentation)
            }

            is DrinkResult.Failure -> mapError(drinkResult.message)
        }
    }

    fun processIntentBack(intent: BackIntent) {
        _intent.value = intent
    }

    private fun loadDrinks() {
        viewModelScope.launch {
            drinksApiKtor.getDrinksList()
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    mapError(e.message)
                }
                .collect {
                    processResult(it)
                }
        }
    }

    private fun loadDrinksSearch(name: String) {
        viewModelScope.launch {
            drinksApiKtor.getDrinksListWithSearch(name)
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    mapError(e.message)
                }
                .collect {
                    processResult(it)
                }
        }
    }

    private fun loadSearch() {
        try {
            _state.value = DrinkState.ListDrinkSuccess(drinksList.value)
        } catch (error: Exception) {
            mapError(error.message)
        }
    }

    private fun loadingOneDrink(index: Int) {
        try {
            _state.value = DrinkState.OneDrinkSuccess(
                drinksList.value.drinkInfoPresentation[index]
            )
        } catch (error: Exception) {
            mapError(error.message)
        }
    }

    private fun mapError(message: String?) {
        _state.value = DrinkState.Error(message = message.orEmpty())
    }
}