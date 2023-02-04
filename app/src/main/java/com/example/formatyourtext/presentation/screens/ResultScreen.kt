package com.example.formatyourtext.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ExperimentalGraphicsApi
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController
import com.example.formatyourtext.R
import com.example.formatyourtext.presentation.components.Wallpaper


@OptIn(ExperimentalGraphicsApi::class)
@Composable
fun ResultScreen(navController: NavController, text: String) {

    val clipboardManager: androidx.compose.ui.platform.ClipboardManager =
        LocalClipboardManager.current
    Wallpaper(itemId = R.drawable.wallpaper3)

    Column(
        modifier = Modifier
            .background(Color.hsl(0.35F, 0.45F, 0.82F, 0.6F))
            .fillMaxSize()
    )
    {
        IconButton(onClick = {
            navController.navigate(Screen.Settings.route)  {
                popUpTo(Screen.Result.route) {
                    inclusive = false
                } //куда перебросить стрелка назад, когда тебя уже перебросят по адресу
            }                              // в нашем случае возврат со страницы Settings
        }) {
            Icon(Icons.Filled.Settings, contentDescription = "Настройки")
        }
        Text(
            text = stringResource(R.string.result),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            fontSize = 5.em
        )
        TextField(
            value = text,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8F)
                .padding(horizontal = 20.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    clipboardManager.setText(AnnotatedString((text)))
                },
                modifier = Modifier
                    .padding(vertical = 20.dp),
            ) {
                Text("Копировать текст", fontSize = 4.em)
            }
            Button(
                onClick = {
                    navController.navigate(Screen.Main.route) {
                        popUpTo(Screen.Main.route) {
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier
                    .padding(vertical = 20.dp),
            ) {
                Text("Назад", fontSize = 4.em)
            }
        }
    }
}