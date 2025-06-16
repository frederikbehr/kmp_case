package org.example.kmp_case.product_category.data

import org.example.kmp_case.core.domain.ColorUtils
import org.example.kmp_case.product_category.domain.ProductCategory

class TestCategoryRepository : CategoryRepository {
    private val categories = listOf(
        ProductCategory(0, null, "Menuer", ColorUtils.parseColor("#a61600")),
        ProductCategory(1, null, "Burgere", ColorUtils.parseColor("#102bc4")),
        ProductCategory(2, null, "Sides & Dips", ColorUtils.parseColor("#108724")),
        ProductCategory(4, null, "Happy Meal®", ColorUtils.parseColor("#570fbd")),
        ProductCategory(5, null, "Kolde drikke", ColorUtils.parseColor("#404040")),
        ProductCategory(6, null, "McCafé Barista", ColorUtils.parseColor("#c79610")),
        ProductCategory(7, null, "Is", ColorUtils.parseColor("#05855e")),
    )

    override suspend fun getCategories(): List<ProductCategory> = categories
}