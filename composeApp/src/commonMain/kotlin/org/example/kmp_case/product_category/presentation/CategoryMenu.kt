package org.example.kmp_case.product_category.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.kmp_case.product_category.domain.ProductCategory

@Composable
fun CategoryMenu(
    categories: List<ProductCategory>,
    selectedCategory: ProductCategory?,
    onClick: (ProductCategory?) -> Unit,
    modifier: Modifier
) {
    Box(
        modifier = modifier
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(top = 24.dp)) {
            items(categories) { category ->
                CategoryButton(
                    category = category,
                    isSelected = selectedCategory == category,
                    onClick = { onClick(category) },
                )
            }
        }
    }
}