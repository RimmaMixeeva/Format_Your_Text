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
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController
import com.example.formatyourtext.R
import com.example.formatyourtext.domain.entity.SettingsStorage
import com.example.formatyourtext.domain.entity.TextStorage
import com.example.formatyourtext.domain.useCase.fillSettingStorage
import com.example.formatyourtext.domain.useCase.handleText
import com.example.formatyourtext.presentation.components.Wallpaper
import kotlinx.coroutines.*

@OptIn(ExperimentalGraphicsApi::class)
@Composable
fun MainScreen(navController: NavController) {
    //storage
    val storage = SettingsStorage.getInstance()
    val scope = CoroutineScope(Dispatchers.Default)
    val clipboardManager: androidx.compose.ui.platform.ClipboardManager =
        LocalClipboardManager.current
    var text by remember {
        mutableStateOf(TextStorage.getInstance().text)
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
            onValueChange = { newText -> text = newText
                              TextStorage.getInstance().setNewText(newText)},
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
                    text += clipboardManager.getText()
                    TextStorage.getInstance().setNewText(text)
                }
            ) {
                Text("Вставить", fontSize = 3.em)
            }
            Button(
                onClick = {
                   text = ""
                   TextStorage.getInstance().setNewText(text)
                }
            ) {
                Text("Очистить", fontSize = 3.em)
            }
            Button(
                onClick = {
                    if (text!="") {
                        TextStorage.getInstance().setNewText(text)
                        scope.launch {
                            async { handleText(text, context, scope) }.await()
                            withContext(Dispatchers.Main) {
                                navController.navigate(Screen.Result.route + "/" + "some result")
                            }
                        }
                    }
                    else {
                        val toast = Toast.makeText(context, "Заполните пустое поле", Toast.LENGTH_SHORT)
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
