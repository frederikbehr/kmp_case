package org.example.kmp_case.menu.presentation

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.kmp_case.product.data.ProductRepository
import org.example.kmp_case.product.data.TestProductRepository
import org.example.kmp_case.product.domain.Product
import org.example.kmp_case.product.presentation.ProductButton
import org.example.kmp_case.product_category.domain.ProductCategory
import kotlin.math.floor

@Composable
fun MenuList(
    modifier: Modifier = Modifier,
    selectedCategory: ProductCategory?,
    onClick: (Product?) -> Unit,
) {
    val repository: ProductRepository = TestProductRepository()
    val products by produceState(initialValue = emptyList<Product>(), key1 = repository) {
        value = repository.getProductsByCategory(selectedCategory?.name) // suspend call
    }
    BoxWithConstraints(
        modifier = modifier
    ) {
        val itemsPerRow: Int = floor(maxWidth.value / 150).toInt()
        val spacing = 8.dp
        val buttonSize = (maxWidth - spacing * (itemsPerRow + 1)) / itemsPerRow
        LazyVerticalGrid(
            columns = GridCells.Fixed(itemsPerRow),
            modifier = Modifier.padding(horizontal = spacing, vertical = 24.dp)
        ) {
            items(products) { product ->
                ProductButton(
                    product = product,
                    onClick = { onClick(product) },
                    modifier = Modifier.size(buttonSize).padding(spacing/2)
                )
            }
        }

    }
}