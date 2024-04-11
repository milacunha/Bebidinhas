package com.camilacunha.bebidinhas.ui

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewModelScope
import com.camilacunha.bebidinhas.MainViewModel
import com.camilacunha.bebidinhas.R
import com.camilacunha.bebidinhas.intent.BackIntent
import com.camilacunha.bebidinhas.intent.DrinkIntent
import com.camilacunha.bebidinhas.intent.DrinkState
import com.camilacunha.bebidinhas.ui.component.ListDrinksComponent
import com.camilacunha.bebidinhas.ui.screen.DrinkScreen
import com.camilacunha.bebidinhas.ui.screen.ErrorScreen
import com.camilacunha.bebidinhas.ui.screen.HomeScreen
import com.camilacunha.bebidinhas.ui.screen.SplashScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val MAIN_ROUTE: String = "main-route"

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val showToastExit = remember { mutableStateOf(false) }
    val activity = (LocalContext.current as Activity)
    val context = LocalContext.current
    val intent = viewModel.intent.value
    val state = viewModel.state.value

    if (showToastExit.value) {
        Toast.makeText(context, "Pressione novamente para sair", Toast.LENGTH_SHORT).show()
        showToastExit.value = false
    }

    when (state) {
        is DrinkState.Loading -> {
            SplashScreen()
        }

        is DrinkState.ListDrinkSuccess -> {
            HomeScreen(
                onClickSearch = {
                    viewModel.viewModelScope.launch {
                        viewModel.processIntent(DrinkIntent.SearchDrinks(it))
                    }
                }
            ) {
                ListDrinksComponent(
                    onRecipeClick = {
                        viewModel.viewModelScope.launch {
                            viewModel.processIntent(DrinkIntent.LoadOneDrink(it))
                        }
                    },
                    listDrink = state.drinkList
                )
            }
        }

        is DrinkState.OneDrinkSuccess -> {
            DrinkScreen(
                onClickBack = {
                    viewModel.viewModelScope.launch {
                        viewModel.processIntent(DrinkIntent.LoadDrinks)
                    }
                },
                drinkInfoPresentation = state.oneDrink
            )
        }

        is DrinkState.Error -> {
            ErrorScreen(
                errorMessage = state.message ?: context.getString(R.string.empty_list_drinks),
                onClickTryAgain = { viewModel.processIntent(DrinkIntent.HomeDrinks) }
            )
        }
    }

    BackHandler {
        when (state) {
            is DrinkState.Error -> {
                activity.finish()
            }

            is DrinkState.ListDrinkSuccess -> {
                when (intent) {
                    BackIntent.FirstTouch -> {
                        showToastExit.value = true
                        viewModel.viewModelScope.launch {
                            delay(2000)
                            showToastExit.value = false
                        }
                        if (showToastExit.value) {
                            viewModel.processIntentBack(BackIntent.SecondTouch)
                        }
                    }

                    BackIntent.SecondTouch -> {
                        activity.finish()
                    }
                }
            }

            is DrinkState.Loading -> {
                activity.finish()
            }

            is DrinkState.OneDrinkSuccess -> {
                viewModel.processIntentBack(BackIntent.FirstTouch)
                viewModel.viewModelScope.launch {
                    viewModel.processIntent(DrinkIntent.LoadDrinks)
                }
            }
        }
    }
}