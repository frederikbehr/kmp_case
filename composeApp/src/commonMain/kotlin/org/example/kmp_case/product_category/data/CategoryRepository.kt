package org.example.kmp_case.product_category.data

import org.example.kmp_case.product_category.domain.ProductCategory

interface CategoryRepository {
    suspend fun getCategories(): List<ProductCategory>
}