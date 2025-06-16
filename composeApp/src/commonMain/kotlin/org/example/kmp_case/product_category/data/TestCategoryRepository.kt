package org.example.kmp_case.product_category.data

import org.example.kmp_case.core.domain.ColorUtils
import org.example.kmp_case.product_category.domain.ProductCategory

class TestCategoryRepository : CategoryRepository {
    private val categories = listOf(
        ProductCategory(0, null, "Menuer", ColorUtils.parseColor("#0000ff")),
        ProductCategory(1, null, "Burgere", ColorUtils.parseColor("#ff0000")),
        ProductCategory(2, null, "Sides & Dips", ColorUtils.parseColor("#00ff00")),
        ProductCategory(4, null, "Happy Meal®", ColorUtils.parseColor("#ffff00")),
        ProductCategory(5, null, "Kolde drikke", ColorUtils.parseColor("#2299ff")),
        ProductCategory(6, null, "McCafé Barista", ColorUtils.parseColor("#db553e")),
        ProductCategory(7, null, "Is", ColorUtils.parseColor("#ecca60")),
    )

    override suspend fun getCategories(): List<ProductCategory> = categories
}