package com.example.formatyourtext.presentation.screens

import android.view.Gravity
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.hsl
import androidx.compose.ui.graphics.ExperimentalGraphicsApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController
import com.example.formatyourtext.R
import com.example.formatyourtext.presentation.components.Wallpaper
@OptIn(ExperimentalGraphicsApi::class)
@Composable
fun MainScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    Wallpaper(itemId = R.drawable.wallpaper3)

    Column(
        modifier = Modifier
            .background(hsl(0.35F, 0.45F, 0.82F, 0.6F))
            .fillMaxSize()
    )
    {
        IconButton(onClick = {
            navController.navigate(Screen.Settings.route)
        })
        {
            Icon(Icons.Filled.Settings, contentDescription = "Настройки")
        }
        Text(
            text = stringResource(R.string.text_for_formatting),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            fontSize = 5.em
        )
        TextField(
            value = text,
            onValueChange = { newText -> text = newText },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8F)
                .padding(horizontal = 20.dp)
        )
        Button(
            onClick = {
                if (text!="") navController.navigate(Screen.Result.route + "/" + text)
                else {
                    val toast = Toast.makeText(context, "Заполните пустое поле", Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()
                }
                      },
            modifier = Modifier
                .padding(horizontal = 80.dp, vertical = 20.dp),
        ) {
            Text("Форматировать", fontSize = 5.em)
        }
    }
}