package org.example.kmp_case.product_category.data

import org.example.kmp_case.core.domain.ColorUtils
import org.example.kmp_case.product_category.domain.ProductCategory

class TestCategoryRepository : CategoryRepository {
    private val categories = listOf(
        ProductCategory(0, null, "Menuer", ColorUtils.blue),
        ProductCategory(1, null, "Burgere", ColorUtils.orange),
        ProductCategory(2, null, "Sides & Dips", ColorUtils.green),
        ProductCategory(4, null, "Happy Meal®", ColorUtils.darkBrown),
        ProductCategory(5, null, "Kolde drikke", ColorUtils.brick),
        ProductCategory(6, null, "McCafé Barista", ColorUtils.lightBlue),
        ProductCategory(7, null, "Is", ColorUtils.salmon),
    )

    override suspend fun getCategories(): List<ProductCategory> = categories
}