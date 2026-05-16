package com.example.udemybootcampjetpackcompose2

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavController) {

    val index = remember { mutableStateOf(0) }

    LaunchedEffect(true) {
        Log.e("Anasayfa","LaunchedEffect çalıştı")
        // Sayfa her göründüğünde çalışır
        // Sayfaya geri dönüldüğünde çalışır
    }

    DisposableEffect(Unit) {
        onDispose {
            Log.e("Anasayfa","DisposableEffect çalıştı")
            // Sayfa her görünmez oluğunda çalışır
        }
    }

    Scaffold(topBar = { TopAppBar(title = { Text(text = "Anasayfa") }) }) { paddingValues ->
        Log.e("Anasayfa", "Yenilendi")

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Sayaç : ${index.value} ")

            Button(onClick = {
                index.value += 1

            }) {
                Text(
                    text = "Tıkla"
                )
            }

            Button(onClick = {
                val product = Products(100, "Kol Saati")
                val productJson = Gson().toJson(product)
                navController.navigate("DetailScreen/Hakan/25/1.85f/true/$productJson"){
                    popUpTo("HomePage"){inclusive = true}
                }

            }) {
                Text(
                    text = "Detay"
                )
            }

        }

    }
}