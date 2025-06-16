package org.example.kmp_case.cart_item.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.example.kmp_case.core.domain.Price
import org.example.kmp_case.product.domain.Product

class CartItem(
    val product: Product,
    quantity: Int,
) {
    var quantity by mutableStateOf(quantity)

    val getTotalPrice: Price get() = Price(
        amount = quantity * product.price.amount,
        currency = product.price.currency,
    )

    fun increment() {
        quantity++
    }

    fun decrement() {
        if (quantity > 0) quantity--
    }
}
