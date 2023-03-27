package com.example.formatyourtext.presentation.screens

import android.view.Gravity
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.hsl
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController
import com.example.formatyourtext.R
import com.example.formatyourtext.presentation.components.Wallpaper
import com.example.formatyourtext.presentation.viewModel.MainViewModel

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel) {

    val mainScreenContext = LocalContext.current
    val clipboardManager: androidx.compose.ui.platform.ClipboardManager =
        LocalClipboardManager.current

    var text by remember {
        mutableStateOf(mainViewModel.liveText.value ?: "")
    }
    mainViewModel.liveText.observe(LocalContext.current as ComponentActivity) {
        text = it
    }

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
            onValueChange = { newText -> mainViewModel.setNewText(newText) },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8F)
                .padding(horizontal = 20.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    mainViewModel.setNewText(text + clipboardManager.getText())
                }
            ) {
                Text("Вставить", fontSize = 3.em)
            }
            Button(
                onClick = {
                    mainViewModel.setNewText("")
                }
            ) {
                Text("Очистить", fontSize = 3.em)
            }

            Button(
                onClick = {
                    if ((mainViewModel.liveText.value ?: "").isNotBlank()) {
                        mainViewModel.formatText(navController, mainScreenContext, mainViewModel)
                    } else {
                        val toast =
                            Toast.makeText(
                                mainScreenContext,
                                "Заполните пустое поле",
                                Toast.LENGTH_SHORT
                            )
                        toast.setGravity(Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                }
            ) {
                Text("Форматировать", fontSize = 3.em)
            }
        }
    }
}
