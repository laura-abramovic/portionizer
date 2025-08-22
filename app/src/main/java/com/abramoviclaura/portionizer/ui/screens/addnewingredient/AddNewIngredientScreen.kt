package com.abramoviclaura.portionizer.ui.screens.addnewingredient

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.abramoviclaura.portionizer.R
import com.abramoviclaura.portionizer.ui.theme.LocalDimensionSystem
import com.abramoviclaura.portionizer.ui.theme.PortionizerTheme
import com.abramoviclaura.portionizer.ui.utils.appScreen

@Composable
fun AddNewIngredientScreen(
    onAddClick: () -> Unit,
    onCancelClick: () -> Unit,
) {
    var name by remember { mutableStateOf("") }
    var grams by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .appScreen()
            .imePadding()
            .padding(LocalDimensionSystem.current.spacingDimensions.m)
    ) {
        Text(
            text = stringResource(R.string.add_ingredient),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(LocalDimensionSystem.current.spacingDimensions.xl))

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text(stringResource(R.string.ingredient_name_label))
            },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next)
        )

        Spacer(Modifier.height(LocalDimensionSystem.current.spacingDimensions.s))

        Row(verticalAlignment = Alignment.Bottom) {
            OutlinedTextField(
                value = grams,
                onValueChange = { value ->
                    grams = value.filter { it.isDigit() }
                },
                label = {
                    Text(stringResource(R.string.ingredient_quantity_label))
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done)
            )

            Spacer(Modifier.width(LocalDimensionSystem.current.spacingDimensions.m))

            Text(
                text = stringResource(R.string.grams_label),
                style = MaterialTheme.typography.headlineLarge
            )
        }

        Spacer(Modifier.weight(1f))

        Button(
            onClick = onAddClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.add).uppercase(),
                style = MaterialTheme.typography.headlineSmall
            )
        }

        Spacer(Modifier.height(LocalDimensionSystem.current.spacingDimensions.s))

        Button(
            onClick = onCancelClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.cancel).uppercase(),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview
@Composable
private fun PreviewAddNewIngredientScreen() = PortionizerTheme {
    AddNewIngredientScreen(
        onAddClick = {},
        onCancelClick = {}
    )
}
