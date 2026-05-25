package com.example.form.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
        bodyLarge = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
        ),
        titleLarge = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                lineHeight = 32.sp,
                letterSpacing = 1.sp
        ),
        labelMedium = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.5.sp
        )
)