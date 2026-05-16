package com.example.udemybootcampjetpackcompose2

import android.util.Log
import androidx.activity.compose.BackHandler
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavController,
    gelenAd: String,
    gelenYas: Int,
    gelenBoy: Float,
    gelenBekar: Boolean,
    products: Products
) {


    Scaffold(topBar = { TopAppBar(title = { Text(text = "Detay Sayfa") }) }) { paddingValues ->
        Log.e("Anasayfa", "Yenilendi")

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "$gelenAd - $gelenYas - $gelenBoy - $gelenBekar - ${products.id} - ${products.name}")


        }

    }

    BackHandler(false) { // true : geri dönüş butonu aktif değil true iken parantez içi çalışır false ise çalışmaz
        Log.e("Detay Sayfa", "Geri tuşuna basıldı")

    }
}