package org.example.kmp_case

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.kmp_case.cart.presentation.CheckoutMenu
import org.example.kmp_case.menu.presentation.MenuList
import org.example.kmp_case.payment.presentation.PaymentProcessingDialog
import org.example.kmp_case.product_category.presentation.CategoryMenu

@Composable
fun App() {
    // viewModel is the glue of the application in regards to state.
    // it keeps track of categories, products and the cart.
    val viewModel = remember { MainViewModel() }

    MaterialTheme {

        // When a payment is being initiated, then this Dialog will show as an indicator.
        // Despite being listed here, state dictates whether it is shown or not.
        if (viewModel.paymentProcessor.isLoading.value) {
            PaymentProcessingDialog(viewModel)
        }

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CategoryMenu(
                viewModel = viewModel,
                onClick = { viewModel.setCategory(it) },
                modifier = Modifier.width(200.dp).background(Color.White).fillMaxHeight(),
            ) // Categories - Shows the categories in the left

            MenuList(
                modifier = Modifier.weight(1f).fillMaxHeight().background(Color(0xFFEDEDED)),
                viewModel = viewModel,
                onClick = { viewModel.cart.addProduct(it) },
            ) // Products - Shows the products for the category selected

            CheckoutMenu(
                modifier = Modifier.width(300.dp).fillMaxHeight().background(Color.White),
                viewModel = viewModel
            ) // Cart - Shows the cart
        }
    }
}