package com.abramoviclaura.portionizer.viewcontracts.addnewingredient

import androidx.lifecycle.ViewModel
import com.abramoviclaura.portionizer.entity.Ingredient
import com.abramoviclaura.portionizer.entity.IngredientId
import com.abramoviclaura.portionizer.source.IngredientsListSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import java.util.UUID

private const val DECIMAL_DOT = '.'

class AddNewIngredientViewModel(
    private val ingredientsListSource: IngredientsListSource,
) : ViewModel() {

    private val nameInputPublisher = MutableStateFlow("")
    private val gramsInputPublisher = MutableStateFlow("")

    fun inputsViewState() = combine(
        nameInputPublisher,
        gramsInputPublisher,
        AddNewIngredientViewState::Inputs
    )

    fun addButtonViewState() = combine(
        nameInputPublisher,
        gramsInputPublisher,
    ) { name, grams ->
        val gramsValue = grams.toFloatOrNull()
        val enabled = name.isNotBlank() && grams.isNotBlank() && gramsValue != null
        AddNewIngredientViewState.AddButton(enabled)
    }

    fun onAddButtonClick() {
        val grams = gramsInputPublisher.value.toFloatOrNull() ?: return

        ingredientsListSource.addIngredient(
            Ingredient(
                id = IngredientId(value = UUID.randomUUID().toString()),
                name = nameInputPublisher.value,
                grams = grams
            )
        )
    }

    fun onNameInputChange(input: String) {
        nameInputPublisher.value = input
    }

    fun onGramsInputChange(input: String) {
        gramsInputPublisher.value = input.trim().filter { it.isDigit() || it == DECIMAL_DOT }
    }
}
