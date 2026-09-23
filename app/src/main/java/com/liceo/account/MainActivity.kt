package com.liceo.account

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.liceo.account.ui.LiceoAccountApp
import com.liceo.account.ui.theme.LiceoAccountTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { LiceoAccountTheme { LiceoAccountApp() } }
    }
}
