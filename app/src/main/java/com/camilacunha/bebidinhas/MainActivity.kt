package com.camilacunha.bebidinhas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.camilacunha.bebidinhas.ui.MAIN_ROUTE
import com.camilacunha.bebidinhas.ui.MainScreen
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = MAIN_ROUTE) {
                composable(MAIN_ROUTE) { MainScreen(viewModel) }
            }
        }
    }
}
