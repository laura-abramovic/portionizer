package com.abramoviclaura.portionizer.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.abramoviclaura.portionizer.R
import com.abramoviclaura.portionizer.ui.theme.LocalDimensionSystem
import com.abramoviclaura.portionizer.ui.theme.PortionizerTheme

@Composable
fun RatioDialogContent(
    onSplitButtonClick: () -> Unit,
    onCancelButtonClick: () -> Unit,
) {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    var firstValue by remember { mutableStateOf("") }
    var secondValue by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(LocalDimensionSystem.current.spacingDimensions.m)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = firstValue,
                onValueChange = { value ->
                    firstValue = value.filter { it.isDigit() }
                },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
                modifier = Modifier
                    .focusRequester(focusRequester)
                    .weight(1f)
            )

            Text(
                text = ":",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(horizontal = LocalDimensionSystem.current.spacingDimensions.m)
            )

            OutlinedTextField(
                value = secondValue,
                onValueChange = { value ->
                    secondValue = value.filter { it.isDigit() }
                },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
                modifier = Modifier
                    .focusRequester(focusRequester)
                    .weight(1f)
            )
        }

        Spacer(Modifier.height(LocalDimensionSystem.current.spacingDimensions.l))

        Button(
            onClick = {
                onSplitButtonClick()
            },
            enabled = firstValue.isNotBlank() && secondValue.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.add).uppercase(),
                style = MaterialTheme.typography.headlineSmall
            )
        }

        Spacer(Modifier.height(LocalDimensionSystem.current.spacingDimensions.s))

        Button(
            onClick = onCancelButtonClick,
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
private fun RatioDialogContentPreview() = PortionizerTheme {
    RatioDialogContent(onSplitButtonClick = {}, onCancelButtonClick = {})
}
