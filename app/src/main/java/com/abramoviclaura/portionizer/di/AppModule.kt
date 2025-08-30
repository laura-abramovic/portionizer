package com.abramoviclaura.portionizer.di

import com.abramoviclaura.portionizer.viewcontracts.ingredientslist.IngredientsListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::IngredientsListViewModel)
}
