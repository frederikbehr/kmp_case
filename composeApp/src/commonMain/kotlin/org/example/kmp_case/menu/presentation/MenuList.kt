package org.example.kmp_case.menu.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.example.kmp_case.product.data.ProductRepository
import org.example.kmp_case.product.data.TestProductRepository
import org.example.kmp_case.product.domain.Product
import org.example.kmp_case.product_category.domain.ProductCategory

@Composable
fun MenuList(modifier: Modifier = Modifier, selectedCategory: ProductCategory?) {
    val repository: ProductRepository = TestProductRepository()
    val products by produceState(initialValue = emptyList<Product>(), key1 = repository) {
        value = repository.getProductsByCategory(selectedCategory?.name) // suspend call
    }
    Box(
        Modifier
            .fillMaxHeight()
            .background(Color.Gray)
    ) {

    }
}