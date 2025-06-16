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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.kmp_case.product_category.domain.ProductCategory
import org.example.kmp_case.product_category.data.CategoryRepository
import org.example.kmp_case.product_category.data.TestCategoryRepository



@Composable
fun CategoryMenu(repository: CategoryRepository = TestCategoryRepository()) {
    val categories by produceState(initialValue = emptyList<ProductCategory>(), key1 = repository) {
        value = repository.getCategories() // suspend call
    }
    val selectedCategory = remember { mutableStateOf<ProductCategory?>(null) }
    Box(
        Modifier
            .width(200.dp)
            .fillMaxHeight()
            .background(Color.White)
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(top = 24.dp)) {
            items(categories) { category ->
                CategoryButton(
                    category = category,
                    isSelected = selectedCategory.value == category,
                    onClick =  { selectedCategory.value = category },
                )
            }
        }
    }
}