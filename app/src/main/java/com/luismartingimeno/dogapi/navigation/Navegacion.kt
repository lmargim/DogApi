package com.luismartingimeno.dogapi.navigation

import BreedDetailScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.luismartingimeno.dogapi.Screens.HomeScreen.HomeScreen
import com.luismartingimeno.dogapi.Screens.LoginScreen.LoginScreen

@Composable
fun Navegacion() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {

        // Pantalla de Login
        composable<Login> {
            LoginScreen { nombreUsuario ->
                // Navegar a Home usando el nombre como parámetro
                navController.navigate(Home(nombreUsuario))
            }
        }

        // Pantalla de Home
        composable<Home> { backStackEntry ->
            val nombreUsuario = backStackEntry.toRoute<Home>().nombreUsuario
            HomeScreen(
                nombreUsuario = nombreUsuario,
                navigateToLogin = {
                    navController.navigate(Login) {
                        popUpTo(Login) { inclusive = true }
                    }
                },
                navigateToBreedDetail = { usuario, breed ->
                    navController.navigate(BreedDetail(usuario, breed))
                }
            )
        }

        // Pantalla de Detalle de la Raza
        composable<BreedDetail> { backStackEntry ->
            val breedDetail = backStackEntry.toRoute<BreedDetail>()
            BreedDetailScreen(
                nombreUsuario = breedDetail.nombreUsuario,
                breed = breedDetail.breed
            ) {
                navController.popBackStack()
            }
        }
    }
}
