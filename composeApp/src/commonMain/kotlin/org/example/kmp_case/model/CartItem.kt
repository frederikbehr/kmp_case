package org.example.kmp_case.model

data class CartItem(
    val product: Product,
    var quantity: Int,
) {
    val getTotalPrice: Double get() = product.price * quantity

    fun increment() = quantity++

    fun decrement() {
        // Used for "removing one" from the cart.
        if (quantity > 0) quantity--
    }
}
