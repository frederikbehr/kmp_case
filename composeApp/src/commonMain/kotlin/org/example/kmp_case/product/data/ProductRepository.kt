package org.example.kmp_case.product.data

import org.example.kmp_case.product.domain.Product

interface ProductRepository {
    suspend fun getAllProducts(): List<Product>
    suspend fun getProductsByCategory(category: String?): List<Product>
}