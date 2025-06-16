package org.example.kmp_case.cart_item.domain

import org.example.kmp_case.product.domain.Product

data class CartItem(
    val product: Product,
    var quantity: Int,
) {
    val getTotalPrice: Double get() = product.price.amount * quantity

    fun increment() = quantity++

    fun decrement() {
        // Used for "removing one" from the cart.
        if (quantity > 0) quantity--
    }
}
