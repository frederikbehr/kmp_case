package org.example.kmp_case.product.domain

import androidx.compose.ui.graphics.Color
import org.example.kmp_case.core.domain.Price

data class Product(
    val id: Int,
    val name: String,
    val category: String,
    val subCategory: String,
    val price: Price,
    val color: Color,
    val imageURL: String?,
)
