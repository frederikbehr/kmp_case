package org.example.kmp_case

import androidx.compose.runtime.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.example.kmp_case.cart.domain.Cart
import org.example.kmp_case.payment.domain.PaymentProcessStatus
import org.example.kmp_case.payment.domain.PaymentProcessor
import org.example.kmp_case.payment.domain.TestPaymentProcessor
import org.example.kmp_case.product.data.ProductRepository
import org.example.kmp_case.product.data.TestProductRepository
import org.example.kmp_case.product.domain.Product
import org.example.kmp_case.product_category.data.CategoryRepository
import org.example.kmp_case.product_category.data.TestCategoryRepository
import org.example.kmp_case.product_category.domain.ProductCategory

class MainViewModel(
    private val categoryRepository: CategoryRepository = TestCategoryRepository(),
    private val productRepository: ProductRepository = TestProductRepository(),
) {
    val paymentProcessor: PaymentProcessor by mutableStateOf(TestPaymentProcessor())
    var categories by mutableStateOf<List<ProductCategory>>(emptyList())
    var selectedCategory by mutableStateOf<ProductCategory?>(null)
    var products by mutableStateOf<List<Product>>(emptyList())
    val cart = Cart()

    init {
        CoroutineScope(Dispatchers.Main).launch {
            categories = categoryRepository.getCategories()
            selectedCategory = categories.firstOrNull()
            loadProducts()
        }
    }

    private suspend fun loadProducts() {
        products = productRepository.getProductsByCategory(selectedCategory?.name)
    }

    fun setCategory(category: ProductCategory?) {
        selectedCategory  = category
        CoroutineScope(Dispatchers.Main).launch {
            loadProducts()
        }
    }

    fun addToCart(product: Product) {
        cart.addProduct(product)
    }

    fun pay() {
        CoroutineScope(Dispatchers.Main).launch {
            if (!paymentProcessor.isLoading.value) {
                paymentProcessor.isLoading.value = true
                paymentProcessor.process()
                delay(500)
                paymentProcessor.isLoading.value = false
                if (paymentProcessor.status.value == PaymentProcessStatus.PaymentSuccessful) {
                    cart.clear()
                }
            }
        }
    }
}