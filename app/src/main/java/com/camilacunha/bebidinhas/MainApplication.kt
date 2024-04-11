package com.camilacunha.bebidinhas

import android.app.Application
import com.camilacunha.bebidinhas.data.network.DrinkHelper
import com.camilacunha.bebidinhas.data.network.DrinkHelperImpl
import com.camilacunha.bebidinhas.data.network.DrinksApi
import com.camilacunha.bebidinhas.data.network.NetworkUtils
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(viewModelModule, networkModule)
        }
    }
}

val viewModelModule = module {
    viewModel<MainViewModel> { MainViewModel(get<DrinkHelper>()) }
}

val networkModule = module {
    single<DrinkHelper> { DrinkHelperImpl(get()) }
    single<DrinksApi> { DrinksApi(NetworkUtils.ktor) }
}