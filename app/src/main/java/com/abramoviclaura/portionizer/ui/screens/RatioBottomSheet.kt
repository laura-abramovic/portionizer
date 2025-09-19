package com.abramoviclaura.portionizer.ui.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import com.abramoviclaura.portionizer.ui.components.RatioDialogContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RatioBottomSheet(
    onSplitButtonClick: (Int, Int) -> Unit,
    onCancelButtonClick: () -> Unit,
    onDismissRequest: () -> Unit,
) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { sheetValue ->
            when (sheetValue) {
                SheetValue.Expanded, SheetValue.Hidden -> true
                else -> false
            }
        }
    )

    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = onDismissRequest
    ) {
        RatioDialogContent(
            onSplitButtonClick = onSplitButtonClick,
            onCancelButtonClick = onCancelButtonClick
        )
    }
}
