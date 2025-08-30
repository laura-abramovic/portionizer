package com.abramoviclaura.portionizer.navigation

import androidx.navigation.NavController
import kotlinx.serialization.Serializable

@Serializable
object IngredientsList

@Serializable
object AddNewIngredient

abstract class Router(private val navController: NavController) {

    fun goBack() {
        navController.popBackStack()
    }
}
