package com.abramoviclaura.portionizer.di

import androidx.navigation.NavController
import com.abramoviclaura.portionizer.viewcontracts.ingredientslist.IngredientsListRouter
import com.abramoviclaura.portionizer.viewcontracts.ingredientslist.IngredientsListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory { (navController: NavController) -> IngredientsListRouter(navController) }

    viewModel { IngredientsListViewModel() }
}
