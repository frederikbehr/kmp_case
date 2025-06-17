package org.example.kmp_case.menu.presentation

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.kmp_case.MainViewModel
import org.example.kmp_case.product.domain.Product
import org.example.kmp_case.product.presentation.ProductButton
import kotlin.math.floor

@Composable
fun MenuList(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
    onClick: (Product?) -> Unit,
) {
    BoxWithConstraints(
        modifier = modifier
    ) {
        val itemsPerRow: Int = floor(maxWidth.value / 150).toInt()
        val spacing = 8.dp
        val buttonSize = (maxWidth - spacing * (itemsPerRow + 1)) / itemsPerRow
        LazyVerticalGrid(
            columns = GridCells.Fixed(itemsPerRow),
            modifier = Modifier.padding(horizontal = spacing),
            contentPadding = PaddingValues(top = 24.dp, bottom = 64.dp),
        ) {
            items(viewModel.products) { product ->
                ProductButton(
                    product = product,
                    onClick = { onClick(product) },
                    modifier = Modifier.size(buttonSize).padding(spacing/2)
                )
            }
        }

    }
}