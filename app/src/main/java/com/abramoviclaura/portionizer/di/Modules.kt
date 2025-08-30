package com.abramoviclaura.portionizer.di

import androidx.navigation.NavController
import com.abramoviclaura.portionizer.source.IngredientsListSource
import com.abramoviclaura.portionizer.viewcontracts.addnewingredient.AddNewIngredientRouter
import com.abramoviclaura.portionizer.viewcontracts.addnewingredient.AddNewIngredientViewModel
import com.abramoviclaura.portionizer.viewcontracts.ingredientslist.IngredientsListRouter
import com.abramoviclaura.portionizer.viewcontracts.ingredientslist.IngredientsListViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val routerModule = module {
    factory { (navController: NavController) -> IngredientsListRouter(navController) }
    factory { (navController: NavController) -> AddNewIngredientRouter(navController) }
}

val viewModelModule = module {
    viewModel { IngredientsListViewModel(ingredientsListSource = get()) }
    viewModel { AddNewIngredientViewModel(ingredientsListSource = get()) }
}

val sourceModule = module {
    singleOf(::IngredientsListSource)
}
