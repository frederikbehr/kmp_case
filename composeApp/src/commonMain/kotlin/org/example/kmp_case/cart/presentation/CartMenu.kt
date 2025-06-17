package org.example.kmp_case.cart.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.kmp_case.cart.domain.Cart
import org.example.kmp_case.cart_item.presentation.CartItemView

@Composable
fun CartMenu(modifier: Modifier, cart: Cart) {
    Box(
        modifier = modifier
    ) {
        if (cart.cart.isEmpty()) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    imageVector = Icons.Filled.ShoppingBasket,
                    contentDescription = "Empty cart",
                    modifier = Modifier.size(32.dp).padding(bottom = 8.dp),
                    tint = Color.LightGray
                )
                Text(
                    text = "No products added",
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = Color.LightGray
                )
            }
        } else {
            LazyColumn(
                modifier = modifier.padding(top = 12.dp),
                contentPadding = PaddingValues(bottom = 32.dp)
            ) {
                items(cart.cart) { item ->
                    CartItemView(
                        item,
                        onRemoveItem = { cart.removeCartItem(item) }
                    )
                }
            }
        }
    }
}