package com.luismartingimeno.dogapi.navigation

import BreedDetailScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.luismartingimeno.dogapi.Screens.HomeScreen.HomeScreen
import com.luismartingimeno.dogapi.Screens.LoginScreen.LoginScreen

@Composable
fun Navegacion() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login") {

        // Pantalla de Login
        composable("Login") {
            LoginScreen { nombreUsuario ->
                // Navegar a Home usando el nombre como parámetro
                navController.navigate("Home/$nombreUsuario")
            }
        }

        // Pantalla de Home
        composable(
            route = "Home/{nombreUsuario}",
            arguments = listOf(
                navArgument("nombreUsuario") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val nombreUsuario = backStackEntry.arguments?.getString("nombreUsuario") ?: ""
            HomeScreen(
                nombreUsuario = nombreUsuario,
                navigateToLogin = {
                    navController.navigate("Login") {
                        popUpTo("Login") { inclusive = true }
                    }
                },
                navigateToBreedDetail = { nombre, breed ->
                    navController.navigate("BreedDetail/$nombre/$breed")
                }
            )
        }

        // Pantalla de Detalle de la Raza
        composable(
            route = "BreedDetail/{nombreUsuario}/{breed}",
            arguments = listOf(
                navArgument("nombreUsuario") { type = NavType.StringType },
                navArgument("breed") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val nombreUsuario = backStackEntry.arguments?.getString("nombreUsuario") ?: ""
            val breed = backStackEntry.arguments?.getString("breed") ?: ""
            BreedDetailScreen(
                nombreUsuario = nombreUsuario,
                breed = breed
            ) {
                navController.popBackStack()
            }
        }
    }
}
