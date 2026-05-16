package com.example.udemybootcampjetpackcompose2

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson

@Composable
fun Navigation(selectedPage : String) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = selectedPage) {

        composable("HomePage") {
            HomePage(navController = navController)
        }

        composable("SettingsPage") {
            SettingsPage(navController = navController)
        }

        composable(
            "DetailScreen/{ad}/{yas}/{boy}/{bekar}/{products}",
            arguments = listOf(
                navArgument("ad") { type = NavType.StringType },
                navArgument("yas") { type = NavType.IntType },
                navArgument("boy") { type = NavType.FloatType },
                navArgument("bekar") { type = NavType.BoolType },
                navArgument("products"){type = NavType.StringType}
            )) {
            val ad = it.arguments?.getString("ad")!!
            val yas = it.arguments?.getInt("yas")!!
            val boy = it.arguments?.getFloat("boy")!!
            val bekar = it.arguments?.getBoolean("bekar")!!

            val jsonProducts = it.arguments?.getString("products")!!
            val products = Gson().fromJson(jsonProducts, Products:: class.java)
            DetailScreen(navController = navController, ad, yas, boy, bekar,products)
        }

    }
}