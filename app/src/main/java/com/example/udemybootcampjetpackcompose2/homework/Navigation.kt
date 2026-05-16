package com.example.udemybootcampjetpackcompose2.homework

import androidx.compose.runtime.Composable
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



@Composable
fun Navigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HomePagee"){

       composable("HomePagee"){
           HomePage(navController = navController)
       }
        composable("ScreenA"){
            ScreenA(navController = navController)
        }
        composable("ScreenB"){
            ScreenB(navController = navController)
        }
        composable("ScreenX"){
            ScreenX(navController = navController)
        }
        composable("ScreenY"){
            ScreenY(navController = navController)
        }
    }
}