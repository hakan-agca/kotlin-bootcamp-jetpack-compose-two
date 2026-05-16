package com.example.udemybootcampjetpackcompose2


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar() {

    var selectedItem = remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                content = {
                    NavigationBarItem(
                        selectedItem.value == 0,
                        onClick = {selectedItem.value = 0},
                        icon = {
                            Icon(painterResource(R.drawable.homepage), "")
                        },
                        label = {
                            Text(text = stringResource(R.string.home_page))
                        }
                    )

                    NavigationBarItem(
                        selectedItem.value == 1,
                        onClick = {selectedItem.value = 1},
                        icon = {
                            Icon(painterResource(R.drawable.settings), "")
                        },
                        label = {
                            Text(text = stringResource(R.string.settings))
                        }
                    )
                }

            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (selectedItem.value == 0) Navigation(selectedPage = "HomePage")
            if (selectedItem.value == 1) Navigation(selectedPage = "SettingsPage")


        }

    }


}