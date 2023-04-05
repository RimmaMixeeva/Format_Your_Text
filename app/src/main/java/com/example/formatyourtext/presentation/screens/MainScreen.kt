package com.example.formatyourtext.presentation.screens

import android.view.Gravity
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.hsl
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController
import com.example.formatyourtext.R
import com.example.formatyourtext.presentation.components.Wallpaper
import com.example.formatyourtext.presentation.viewModel.MainViewModel
import com.example.formatyourtext.ui.theme.BackgroundColor
import com.example.formatyourtext.ui.theme.Orange

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

    // Wallpaper(itemId = R.drawable.wallpaper3)

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
                navController.navigate(Screen.Settings.route)
            })
            {
                Icon(Icons.Filled.Settings, contentDescription = "Настройки")
            }
        }
        TextField(
            value = text,
            placeholder = { Text(text = "Ваш текст") },
            onValueChange = { newText -> mainViewModel.setNewText(newText) },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85F)
                .padding(horizontal = 20.dp, vertical = 50.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Orange),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                mainViewModel.setNewText(text + clipboardManager.getText())
            })
            {
                Icon(
                    ImageVector.vectorResource(R.drawable.ic_paste),
                    contentDescription = "Вставить"
                )
            }
            IconButton(onClick = {
                mainViewModel.setNewText("")
            })
            {
                Icon(
                    ImageVector.vectorResource(R.drawable.ic_clean),
                    contentDescription = "Очистить"
                )
            }
            IconButton(onClick = {
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
            })
            {
                Icon(
                    ImageVector.vectorResource(R.drawable.ic_recycle),
                    contentDescription = "Форматировать"
                )
            }
        }
    }
}
