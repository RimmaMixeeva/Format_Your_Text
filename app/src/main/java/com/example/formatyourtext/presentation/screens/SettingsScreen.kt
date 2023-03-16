package com.example.formatyourtext.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController
import com.example.formatyourtext.R
import com.example.formatyourtext.domain.entity.SettingsStorage
import com.example.formatyourtext.presentation.components.ItemRowSample


@Composable
fun SettingsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .background(Color.hsl(0.35F, 0.45F, 0.82F, 0.6F))
            .fillMaxSize()
    )
    {
        IconButton(onClick = {
            navController.popBackStack()
        }) {
            Icon(Icons.Filled.Home, contentDescription = "Настройки")
        }
        Text(
            text = stringResource(R.string.settings),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            fontSize = 5.em
        )
        LazyColumn {
            itemsIndexed(
                SettingsStorage.rowSettingRowModelList.toList()
            )
            { index, item ->
                ItemRowSample(index, item = item)
            }
        }
    }
}