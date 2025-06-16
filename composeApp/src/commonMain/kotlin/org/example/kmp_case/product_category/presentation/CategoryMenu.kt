package org.example.kmp_case.product_category.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                Button(
                    onClick = { selectedCategory.value = category },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp, horizontal = 12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = category.color.copy(alpha = 0.3f)),
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                        if (selectedCategory.value == category) {
                            Icon(
                                imageVector = Icons.Filled.Check,
                                contentDescription = "Selected",
                                tint = Color.Black.copy(alpha = 0.87f),
                                modifier = Modifier.size(28.dp).padding(end = 8.dp),
                            )
                        }
                        Text(
                            text = category.name,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(vertical = 16.dp),
                            color = Color.Black.copy(alpha = 0.87f)
                        )
                    }
                }
            }
        }
    }
}