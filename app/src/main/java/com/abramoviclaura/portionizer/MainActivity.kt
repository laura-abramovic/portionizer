package com.abramoviclaura.portionizer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.abramoviclaura.portionizer.ui.screens.ingredientslist.IngredientsListScreen
import com.abramoviclaura.portionizer.ui.theme.PortionizerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PortionizerTheme {
                IngredientsListScreen(emptyList())
            }
        }
    }
}
