package com.faldi.movieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.faldi.movieapp.presentation.view.Popular
import com.faldi.movieapp.presentation.view.detail.Detail
import com.faldi.movieapp.presentation.view.register.Register
import com.faldi.movieapp.presentation.view.login.Login


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "popular"){
        composable("popular"){
            Popular(navController = navController)
        }
        composable("detail/{idMovie}",
            arguments = listOf(navArgument("idMovie") {
                type = NavType.IntType
                defaultValue = 0
            }
            )
        )
        {backStackEntry ->
            Detail(id= backStackEntry.arguments!!.getInt("idMovie"))
        }
        composable("login"){
            Login(navController)
        }
        composable("regist"){
            Register(navController = navController)
        }
    }
}