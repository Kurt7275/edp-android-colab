package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Persist theme across recompositions
            var isDarkTheme by rememberSaveable { mutableStateOf(false) }
            MyApplicationTheme(darkTheme = isDarkTheme) {
                ProfileScreen(
                    onThemeToggle = { isDarkTheme = !isDarkTheme },
                    isDarkTheme   = isDarkTheme,
                )
            }
        }
    }
}
