package com.abramoviclaura.portionizer.entity

@JvmInline
value class IngredientId(val value: String)

data class Ingredient(
    val id: IngredientId,
    val name: String,
    val grams: Float,
)
