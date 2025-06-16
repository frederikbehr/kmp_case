package org.example.kmp_case

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.example.kmp_case.checkout.presentation.CheckoutMenu
import org.example.kmp_case.menu.presentation.MenuList
import org.example.kmp_case.product_category.data.CategoryRepository
import org.example.kmp_case.product_category.data.TestCategoryRepository
import org.example.kmp_case.product_category.domain.ProductCategory
import org.example.kmp_case.product_category.presentation.CategoryMenu

@Composable
fun App() {
    val repository: CategoryRepository = TestCategoryRepository()
    val categories by produceState(initialValue = emptyList<ProductCategory>(), key1 = repository) {
        value = repository.getCategories() // suspend call
    }
    val selectedCategory = remember { mutableStateOf<ProductCategory?>(null) }

    LaunchedEffect(categories) { // When data is loaded, this sets the selected category to the first category
        if (categories.isNotEmpty() && selectedCategory.value == null) {
            selectedCategory.value = categories.first()
        }
    }

    MaterialTheme {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CategoryMenu(
                categories = categories,
                selectedCategory = selectedCategory.value,
                onClick = { selectedCategory.value = it }
            ) // Categories - Shows the categories in the left

            MenuList(modifier = Modifier.weight(1f)) // Products - Shows the products for the category selected

            CheckoutMenu() // Cart - Shows the cart
        }
    }
}