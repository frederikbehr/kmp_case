package org.example.kmp_case.product.domain

data class Product(
    val id: String,
    val name: String,
    val category: String,
    val subCategory: String,
    val price: Double,
    val colorHex: String,
    val imageURL: String?,
)
