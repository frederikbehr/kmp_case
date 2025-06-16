package org.example.kmp_case.product_category.domain

import androidx.compose.ui.graphics.Color

data class ProductCategory(
    val id: Int,
    val sortRank: Int?,
    val name: String,
    val color: Color,
)
