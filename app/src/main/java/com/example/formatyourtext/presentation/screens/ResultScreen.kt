package com.example.formatyourtext.presentation.screens


import android.view.Gravity
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.formatyourtext.R
import com.example.formatyourtext.presentation.navigation.Screen
import com.example.formatyourtext.presentation.viewModel.MainViewModel
import com.example.formatyourtext.ui.theme.BackgroundColor
import com.example.formatyourtext.ui.theme.Orange

@Composable
fun ResultScreen(navController: NavController, viewModel: MainViewModel) {
    val context = LocalContext.current
    var text by remember { mutableStateOf(viewModel.liveText.value ?: "") }

    val clipboardManager: androidx.compose.ui.platform.ClipboardManager =
        LocalClipboardManager.current

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
                navController.navigate(Screen.Settings.route) {
                    popUpTo(Screen.Result.route) {
                        inclusive = false
                    }
                }
            }) {
                Icon(Icons.Filled.Settings, contentDescription = "Настройки")
            }
        }

        TextField(
            value = text,
            onValueChange = { newText -> text = newText },
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
                clipboardManager.setText(AnnotatedString((text)))
                val toast = Toast.makeText(context, "Текст скопирован", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            })
            {
                Icon(
                    ImageVector.vectorResource(R.drawable.ic_copy),
                    contentDescription = "Копировать"
                )
            }
            IconButton(onClick = {
                navController.navigate(Screen.Main.route) {
                    popUpTo(Screen.Main.route) {
                        inclusive = true
                    }
                }
            })
            {
                Icon(
                    ImageVector.vectorResource(R.drawable.ic_back),
                    contentDescription = "Обратно"
                )
            }
        }
    }
}