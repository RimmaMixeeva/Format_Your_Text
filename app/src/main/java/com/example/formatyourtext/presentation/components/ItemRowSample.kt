package com.example.formatyourtext.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ExperimentalGraphicsApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.formatyourtext.data.DataStoreManager
import com.example.formatyourtext.domain.entity.ItemSettingsRowModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalGraphicsApi::class)
@Composable
fun ItemRowSample(itemNumber: Int, item: ItemSettingsRowModel) {
    //context
    val context = LocalContext.current
    //scope
    val scope = rememberCoroutineScope()
    //datastore info
    val dataStore = DataStoreManager(context)
    //get saved state of setting
    val savedSetting = dataStore.getSetting(itemNumber).collectAsState(initial = false)

    val isExpanded = remember { mutableStateOf(savedSetting.value)}
    //val checkedState = remember { mutableStateOf(savedSetting.value)}
    Card(
        elevation = 3.dp,
        backgroundColor = Color.hsl(0.32F, 0.20F, 0.89F, 0.9F),
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isExpanded.value = !isExpanded.value }
            ) {
                Switch(
                    checked = savedSetting.value,
                    onCheckedChange = {
                                      scope.launch { dataStore.setSetting(itemNumber, it) }},
                    modifier = Modifier.padding(start = 8.dp)
                )
                Text(
                    text = item.settingName,
                    //text = savedSetting.value.toString(),
                    modifier = Modifier
                        .padding(vertical = 12.dp, horizontal = 5.dp)
                        .fillMaxWidth(),
                    fontSize = 4.em,
                    textAlign = TextAlign.Start
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .background(
                        if (isExpanded.value) Color.hsl(0.32F, 0.20F, 0.94F, 0.9F)
                        else Color.hsl(0.32F, 0.20F, 0.89F, 0.9F)
                    )
                    .padding(if (isExpanded.value) 4.dp else 0.dp)
                    .requiredHeight(if (isExpanded.value) 30.dp else 0.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.exampleBefore,
                    fontSize = 4.em
                )
                Icon(Icons.Filled.ArrowForward, contentDescription = "Настройки")
                Text(
                    text = item.exampleAfter,
                    fontSize = 4.em
                )

            }
        }
    }
}