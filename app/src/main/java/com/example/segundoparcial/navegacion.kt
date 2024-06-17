package com.example.segundoparcial.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.segundoparcial.Ciudades
import com.example.segundoparcial.Clima

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "ciudades") {
        composable("ciudades") { Ciudades(navController) }
        composable("clima/{ciudad}") { backStackEntry ->
            val ciudad = backStackEntry.arguments?.getString("ciudad") ?: ""
            Clima(ciudad)
        }
    }
}
