package com.abramoviclaura.portionizer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.abramoviclaura.portionizer.ui.screens.ingredientslist.IngredientsListScreen
import com.abramoviclaura.portionizer.ui.theme.PortionizerTheme
import org.koin.androidx.compose.KoinAndroidContext

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
