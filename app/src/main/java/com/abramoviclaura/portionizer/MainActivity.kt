package com.abramoviclaura.portionizer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abramoviclaura.portionizer.navigation.AddNewIngredient
import com.abramoviclaura.portionizer.navigation.IngredientsList
import com.abramoviclaura.portionizer.ui.screens.addnewingredient.AddNewIngredientScreen
import com.abramoviclaura.portionizer.ui.screens.ingredientslist.IngredientsListScreen
import com.abramoviclaura.portionizer.ui.theme.PortionizerTheme
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PortionizerTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = IngredientsList
                ) {
                    composable<IngredientsList> { IngredientsListScreen(router = koinInject(parameters = { parametersOf(navController) })) }
                    composable<AddNewIngredient> { AddNewIngredientScreen(router = koinInject(parameters = { parametersOf(navController) })) }
                }
            }
        }
    }
}
