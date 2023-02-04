package com.example.formatyourtext.presentation


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ExperimentalGraphicsApi
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.formatyourtext.presentation.components.ItemRowSample
import com.example.formatyourtext.R
import com.example.formatyourtext.domain.entity.ItemSettingsRowModel


class SettingsActivity : ComponentActivity() {
    @OptIn(ExperimentalGraphicsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Color.hsl(0.35F, 0.45F, 0.82F, 0.6F))
                    .fillMaxSize()
            )
            {
                IconButton(onClick = {
                    val intent = Intent(this@SettingsActivity, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0,0)
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
                        listOf(
                        ItemSettingsRowModel("Замена дефиса на тире","-Пример", "—Пример"),
                        ItemSettingsRowModel("Поставить, если нету, пробел после . ? ! !? ","...мера!Он", "...мера! Он"),
                        ItemSettingsRowModel("Поставить, если нету, пробел после тире (—)","—Пример", "— Пример"),
                        ItemSettingsRowModel("Замена дефиса на тире","-Пример", "—Пример"),
                        ItemSettingsRowModel("Замена дефиса на тире","-Пример", "—Пример"),
                        ItemSettingsRowModel("Замена дефиса на тире","-Пример", "—Пример"),
                        ItemSettingsRowModel("Замена дефиса на тире","-Пример", "—Пример"),
                        ItemSettingsRowModel("Замена дефиса на тире","-Пример", "—Пример"),
                        ItemSettingsRowModel("Замена дефиса на тире","-Пример", "—Пример"),
                        )
                    )
                    { _, item ->
                        ItemRowSample(item = item)
                    }

                }

            }


        }

    }
}

