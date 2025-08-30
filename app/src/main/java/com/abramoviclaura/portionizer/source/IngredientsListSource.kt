package com.abramoviclaura.portionizer.source

import com.abramoviclaura.portionizer.entity.Ingredient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class IngredientsListSource {

    private val ingredientsListPublisher = MutableStateFlow<List<Ingredient>>(emptyList())

    fun ingredientsList() = ingredientsListPublisher

    fun addIngredient(ingredient: Ingredient) {
        ingredientsListPublisher.update { ingredients -> ingredients + ingredient }
    }
}
