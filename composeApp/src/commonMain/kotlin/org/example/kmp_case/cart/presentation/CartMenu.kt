package org.example.kmp_case.cart.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.kmp_case.cart.domain.Cart
import org.example.kmp_case.cart_item.presentation.CartItemView

@Composable
fun CartMenu(modifier: Modifier, cart: Cart) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(top = 12.dp),
        contentPadding = PaddingValues(bottom = 64.dp)
    ) {
        items(cart.cart) { item ->
            CartItemView(
                item,
                onRemoveItem = { cart.removeCartItem(item) }
            )
        }
    }
}