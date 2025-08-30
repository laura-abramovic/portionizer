package com.abramoviclaura.portionizer.viewcontracts.addnewingredient

sealed class AddNewIngredientViewState {
    data class Inputs(
        val name: String,
        val grams: String,
    ) : AddNewIngredientViewState() {
        companion object {
            fun initial() = Inputs("", "")
        }
    }

    data class AddButton(val enabled: Boolean) : AddNewIngredientViewState() {
        companion object {
            fun initial() = AddButton(false)
        }
    }
}
