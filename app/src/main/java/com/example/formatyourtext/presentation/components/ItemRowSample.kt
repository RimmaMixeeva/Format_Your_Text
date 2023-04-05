package com.example.formatyourtext.presentation.components

import android.content.res.Resources
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.formatyourtext.data.dataStore.DataStoreManager
import com.example.formatyourtext.domain.entity.ItemSettingsRowModel
import com.example.formatyourtext.ui.theme.*
import kotlinx.coroutines.launch

@Composable
fun ItemRowSample(itemNumber: Int, item: ItemSettingsRowModel) {
    //context
    val context = LocalContext.current
    //scope
    val scope = rememberCoroutineScope()
    //datastore info
    val dataStore = DataStoreManager(context)
    val savedSetting = remember { mutableStateOf(false) }
    //get saved state of setting
    LaunchedEffect(scope) {
        savedSetting.value = dataStore.getSetting(itemNumber)
    }
    val isExpanded = remember { mutableStateOf(false) }

    Card(
        elevation = 3.dp,
        backgroundColor = LightBackgroundColor,
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp)
    ) {
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isExpanded.value = !isExpanded.value }
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    text = item.settingName,
                    modifier = Modifier
                        .padding(vertical = 12.dp, horizontal = 5.dp)
                        .fillMaxWidth(0.9F),
                    fontSize = 4.em,
                    textAlign = TextAlign.Start
                )
                Switch(
                    checked = savedSetting.value,
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Orange,
                        uncheckedThumbColor = Color.White,
                        checkedTrackColor = Orange,
                        uncheckedTrackColor = DirtyWhite
                    ),
                    onCheckedChange = {
                        scope.launch { dataStore.setSetting(itemNumber, it) }
                        savedSetting.value = it
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .background(
                        if (isExpanded.value) Color.White
                    else Color.White
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