package com.example.formatyourtext

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color.Companion.hsl
import androidx.compose.ui.graphics.ExperimentalGraphicsApi
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalGraphicsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var text by remember {
                mutableStateOf("")
            }
          Wallpaper(itemId = R.drawable.wallpaper3)
            Column(
                modifier = Modifier
                    .background(hsl(0.35F, 0.45F, 0.82F, 0.6F))
                    .fillMaxSize()
            )
            {
                IconButton(onClick = {
                    val intent = Intent(this@MainActivity, SettingsActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0,0)
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
                    onClick = {val intent = Intent(this@MainActivity, ResultActivity::class.java)
                               intent.putExtra("text", text)
                               startActivity(intent)
                        overridePendingTransition(0,0)},
                    modifier = Modifier
                        .padding(horizontal = 80.dp, vertical = 20.dp),
                ) {
                    Text ("Форматировать", fontSize = 5.em)
                  }
        }
    }


}

}
