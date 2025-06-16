package org.example.kmp_case.cart.domain

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import org.example.kmp_case.cart_item.domain.CartItem
import org.example.kmp_case.product.domain.Product

class Cart {
    private val _cart = mutableStateListOf<CartItem>()
    val cart: SnapshotStateList<CartItem> get() = _cart

    fun addProduct(product: Product?) {
        if (product == null) return
        val existing = _cart.find { it.product.id == product.id }
        if (existing != null) {
            // CartItem found by the product. Incrementing quantity.
            existing.quantity++
        } else {
            // CartItem was not found by product id. Therefore adding new CartItem with product.
            _cart.add(CartItem(product, 1))
        }
    }

    fun removeCartItem(item: CartItem) {
        if (item.quantity > 1) item.decrement() else _cart.remove(item)
    }

    fun clear() = _cart.clear()

}