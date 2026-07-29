package com.example.myapplication.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// ──────────────────────────────────────────────────────────────────
// "Liceo Maroon" Material 3 Theme
// DO NOT EDIT — theme is provided; read from it in ProfileScreen.kt
// ──────────────────────────────────────────────────────────────────

private val LiceoMaroonDarkColorScheme = darkColorScheme(
    primary            = MaroonPrimaryDark,
    onPrimary          = OnMaroonPrimaryDark,
    primaryContainer   = MaroonContainerDark,
    onPrimaryContainer = OnMaroonContainerDark,
    secondary          = SecondaryDark,
    onSecondary        = OnSecondaryDark,
    surface            = SurfaceDark,
    surfaceVariant     = SurfaceVariantDark,
    onSurface          = OnSurfaceDark,
    onSurfaceVariant   = OnSurfaceVarDark,
)

private val LiceoMaroonLightColorScheme = lightColorScheme(
    primary            = LiceoMaroon,
    onPrimary          = OnLiceoMaroon,
    primaryContainer   = MaroonContainer,
    onPrimaryContainer = OnMaroonContainer,
    secondary          = MaroonSecondary,
    onSecondary        = OnMaroonSecondary,
    surface            = SurfaceLight,
    surfaceVariant     = SurfaceVariantLight,
    onSurface          = OnSurfaceLight,
    onSurfaceVariant   = OnSurfaceVarLight,
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+; disabled so Maroon theme always shows
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> LiceoMaroonDarkColorScheme
        else      -> LiceoMaroonLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography  = Typography,
        content     = content,
    )
}
