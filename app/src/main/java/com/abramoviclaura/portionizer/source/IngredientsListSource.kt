package com.abramoviclaura.portionizer.source

import com.abramoviclaura.portionizer.entity.Ingredient
import com.abramoviclaura.portionizer.entity.Ratio
import com.abramoviclaura.portionizer.entity.SplitIngredient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class IngredientsListSource {

    private val ingredientsListPublisher = MutableStateFlow<List<Ingredient>>(emptyList())

    fun ingredientsList() = ingredientsListPublisher

    fun addIngredient(ingredient: Ingredient) {
        ingredientsListPublisher.update { ingredients -> ingredients + ingredient }
    }

    fun splitIngredients(ratio: Ratio): List<SplitIngredient> {
        val ratioSum = ratio.x + ratio.y

        return ingredientsListPublisher.value.map { ingredient ->
            val xGrams = ingredient.grams * ratio.x / ratioSum
            val yGrams = ingredient.grams - xGrams

            SplitIngredient(
                ingredient = ingredient,
                xGrams = xGrams,
                yGrams = yGrams
            )
        }
    }
}
