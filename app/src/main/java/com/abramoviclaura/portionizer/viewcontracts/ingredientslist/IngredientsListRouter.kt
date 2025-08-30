package com.abramoviclaura.portionizer.viewcontracts.ingredientslist

import androidx.navigation.NavController
import com.abramoviclaura.portionizer.navigation.AddNewIngredient
import com.abramoviclaura.portionizer.navigation.Router

class IngredientsListRouter(private val navController: NavController) : Router(navController) {

    fun showAddIngredientScreen() {
        navController.navigate(AddNewIngredient)
    }
}
