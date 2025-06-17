package org.example.kmp_case.core.domain

import androidx.compose.ui.graphics.Color

class ColorUtils {
    companion object {

        val blue: Color = parseColor("#0090d6")
        val orange: Color = parseColor("#fe6729")
        val green: Color = parseColor("#4b972f")
        val darkBrown: Color = parseColor("#665758")
        val brick: Color = parseColor("#8a5758")
        val lightBlue: Color = parseColor("#00d1f8")
        val salmon: Color = parseColor("#bb4238")
        val darkBlue: Color = parseColor("#1d2b4c")

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