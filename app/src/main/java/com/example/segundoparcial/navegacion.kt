package com.example.segundoparcial.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.segundoparcial.Ciudades
import com.example.segundoparcial.Clima
import com.example.segundoparcial.RetrofitClient

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val servicioAPIClima = RetrofitClient.instance

    NavHost(navController, startDestination = "ciudades") {
        composable("ciudades") {
            Ciudades(navController, servicioAPIClima)
        }
        composable("clima/{ciudad}") { backStackEntry ->
            val ciudad = backStackEntry.arguments?.getString("ciudad") ?: ""
            Clima(navController, ciudad)
        }
    }
}


