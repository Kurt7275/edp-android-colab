package com.example.myapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

// ──────────────────────────────────────────────────────────────────
// "Liceo Maroon" Typography  —  Inter via Downloadable Font
// DO NOT EDIT — theme is provided; read from it in ProfileScreen.kt
// ──────────────────────────────────────────────────────────────────

/**
 * Inter font family loaded from res/font/inter.xml (Google Fonts
 * Downloadable Fonts — no bundled .ttf/.otf files required).
 * Falls back to the system sans-serif on devices without GMS.
 */
val InterFontFamily = FontFamily(Font(R.font.inter))

val Typography = Typography(
    // ── Used for the student's full name (Step 2) ──────────────
    headlineSmall = TextStyle(
        fontFamily    = InterFontFamily,
        fontWeight    = FontWeight.Bold,
        fontSize      = 24.sp,
        lineHeight    = 32.sp,
        letterSpacing = 0.sp,
    ),
    // ── Used for Course · Section subtitle (Step 3) ────────────
    titleMedium = TextStyle(
        fontFamily    = InterFontFamily,
        fontWeight    = FontWeight.Medium,
        fontSize      = 16.sp,
        lineHeight    = 24.sp,
        letterSpacing = 0.15.sp,
    ),
    // ── Used for TopAppBar title ───────────────────────────────
    titleLarge = TextStyle(
        fontFamily    = InterFontFamily,
        fontWeight    = FontWeight.Bold,
        fontSize      = 22.sp,
        lineHeight    = 28.sp,
        letterSpacing = 0.sp,
    ),
    // ── Used for InfoRow label (the small caption above value) ─
    labelMedium = TextStyle(
        fontFamily    = InterFontFamily,
        fontWeight    = FontWeight.Medium,
        fontSize      = 12.sp,
        lineHeight    = 16.sp,
        letterSpacing = 0.5.sp,
    ),
    // ── Used for InfoRow value text ────────────────────────────
    bodyMedium = TextStyle(
        fontFamily    = InterFontFamily,
        fontWeight    = FontWeight.Normal,
        fontSize      = 14.sp,
        lineHeight    = 20.sp,
        letterSpacing = 0.25.sp,
    ),
    bodySmall = TextStyle(
        fontFamily    = InterFontFamily,
        fontWeight    = FontWeight.Normal,
        fontSize      = 12.sp,
        lineHeight    = 16.sp,
        letterSpacing = 0.4.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily    = InterFontFamily,
        fontWeight    = FontWeight.Normal,
        fontSize      = 16.sp,
        lineHeight    = 24.sp,
        letterSpacing = 0.5.sp,
    ),
)