package com.example.formatyourtext.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.formatyourtext.domain.repository.SettingsStorage
import com.example.formatyourtext.presentation.components.ItemRowSample
import com.example.formatyourtext.ui.theme.BackgroundColor
import com.example.formatyourtext.ui.theme.Orange


@Composable
fun SettingsScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .background(BackgroundColor)
            .fillMaxSize()
    )
    {
        Box(
            modifier = Modifier
                .background(Orange)
                .fillMaxWidth()
        ) {
        IconButton(onClick = {
            navController.popBackStack()
        }) {
            Icon(Icons.Filled.Home, contentDescription = "Настройки")
        }
        }

        LazyColumn(modifier = Modifier.padding(top = 20.dp)) {
            itemsIndexed(
                SettingsStorage.rowSettingRowModelList.toList()
            )
            { index, item ->
                ItemRowSample(index, item = item)
            }
        }
    }
}