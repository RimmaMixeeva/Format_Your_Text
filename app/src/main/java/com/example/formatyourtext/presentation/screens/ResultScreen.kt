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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController
import com.example.formatyourtext.R
import com.example.formatyourtext.domain.entity.TextStorage
import com.example.formatyourtext.presentation.components.Wallpaper

@Composable
fun ResultScreen(navController: NavController, text: String) {
    val context = LocalContext.current

    var text by remember { mutableStateOf(TextStorage.text) }

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
            navController.navigate(Screen.Settings.route) {
                popUpTo(Screen.Result.route) {
                    inclusive = false
                }
            }
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
            onValueChange = { newText -> text = newText },
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
                    val toast = Toast.makeText(context, "Текст скопирован", Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()
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