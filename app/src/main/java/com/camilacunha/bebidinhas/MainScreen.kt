package com.camilacunha.bebidinhas

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewModelScope
import com.camilacunha.bebidinhas.intent.BackIntent
import com.camilacunha.bebidinhas.intent.DrinkIntent
import com.camilacunha.bebidinhas.intent.DrinkState
import com.camilacunha.bebidinhas.model.BottomIconsPresentation
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
    val showSearchBar = remember { mutableStateOf(false) }
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
                showSearchBar = showSearchBar,
                bottomMenu = listOf(
                    BottomIconsPresentation(icon = Icons.Outlined.Home) {
                        viewModel.viewModelScope.launch {
                            viewModel.processIntent(DrinkIntent.HomeDrinks)
                        }
                        showSearchBar.value = false
                    },
                    BottomIconsPresentation(icon = Icons.Outlined.Search) {
                        showSearchBar.value = true
                    },
                ),
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
                errorMessage = state.message,
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