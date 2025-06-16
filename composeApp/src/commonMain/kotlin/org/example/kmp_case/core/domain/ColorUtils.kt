package org.example.kmp_case.core.domain

import androidx.compose.ui.graphics.Color

class ColorUtils {
    companion object {
        fun parseColor(hex: String): Color {
            return try {
                Color(
                    red = Integer.valueOf(hex.substring(1, 3), 16) / 255f,
                    green = Integer.valueOf(hex.substring(3, 5), 16) / 255f,
                    blue = Integer.valueOf(hex.substring(5, 7), 16) / 255f,
                    alpha = if (hex.length == 9) Integer.valueOf(hex.substring(7, 9), 16) / 255f else 1f,
                )
            } catch (e: Exception) {
                Color.Gray
            }
        }
    }
}