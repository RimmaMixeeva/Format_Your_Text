package com.example.formatyourtext


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ExperimentalGraphicsApi
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.material.TextField as TextField

class ResultActivity : ComponentActivity() {
    @OptIn(ExperimentalGraphicsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            val clipboardManager: androidx.compose.ui.platform.ClipboardManager = LocalClipboardManager.current
            val text = intent.getStringExtra("text").toString().replace("-"," — ")
            Wallpaper(itemId = R.drawable.wallpaper3)
            Column(
                modifier = Modifier
                    .background(Color.hsl(0.35F, 0.45F, 0.82F, 0.6F))
                    .fillMaxSize()
            )
            {
                IconButton(onClick = {
                    val intent = Intent(this@ResultActivity, SettingsActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0,0)}) {
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

                Row ( modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround) {
                    Button(
                        onClick = {
                            clipboardManager.setText(AnnotatedString((text)))
                            val toast = Toast.makeText(applicationContext, "Текст скопирован", Toast.LENGTH_SHORT)
                            toast.show()
                         },
                        modifier = Modifier
                            .padding(vertical = 20.dp),
                    ) {
                        Text ("Копировать текст", fontSize = 4.em)
                    }
                    Button(
                        onClick = { val intent = Intent(this@ResultActivity, MainActivity::class.java)
                                     startActivity(intent)
                                     overridePendingTransition(0,0)},
                        modifier = Modifier
                            .padding(vertical = 20.dp),
                    ) {
                        Text ("Назад", fontSize = 4.em)
                    }
                }
            }
        }
    }

    private fun formatText(text: String) : String {
        var result =  text.replace(Regex("-")) {
            when(it.value) {
                "-" -> "—"
                else -> it.value
            }
        }
        return result
    }

}
