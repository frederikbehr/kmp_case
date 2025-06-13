package org.example.kmp_case.service

import org.example.kmp_case.model.CartItem
import org.example.kmp_case.model.Product

class OrderService {
    private val _cart = mutableListOf<CartItem>()
    val cart: List<CartItem> get() = _cart

    fun addProduct(product: Product) {
        val existing = _cart.find { it.product.id == product.id }
        if (existing != null) {
            // CartItem found by the product. Incrementing quantity.
            existing.quantity++
        } else {
            // CartItem was not found by product id. Therefore adding new CartItem with product.
            _cart.add(CartItem(product, 1))
        }
    }

    fun removeProduct(product: Product) {
        val item: CartItem? = _cart.find { it.product.id == product.id }
        if (item != null) {
            // CartItem was found from product selected.
            if (item.quantity > 1) item.decrement() else _cart.remove(item)
        } else {
            // CartItem was not found.
            println("OrderService.kt at removeProduct(): CartItem was not found.")
        }
    }

    fun clearCart() = _cart.clear()

    fun totalPrice(): Double = _cart.sumOf { it.getTotalPrice }


}