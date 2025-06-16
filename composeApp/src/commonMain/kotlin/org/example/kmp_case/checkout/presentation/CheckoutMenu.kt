package org.example.kmp_case.checkout.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.kmp_case.cart.domain.Cart
import org.example.kmp_case.cart.presentation.CartMenu
import org.example.kmp_case.core.domain.ColorUtils

@Composable
fun CheckoutMenu(modifier: Modifier, cart: Cart) {
    Box(
        modifier = modifier
            .padding(horizontal = 16.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.padding(top = 32.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Order #123",
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                    color = Color.Black.copy(alpha = 0.87f),
                )
                Button(
                    onClick = { cart.clear() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red.copy(alpha = 0.12f),
                        contentColor = Color.Red,
                        disabledContainerColor = Color.LightGray,
                        disabledContentColor = Color.Gray,
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "Clear",
                        modifier = Modifier.size(22.dp).padding(end = 4.dp),
                    )
                    Text(
                        text = "Clear",
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp,
                    )
                }
            }
            HorizontalDivider(
                thickness = 2.dp,
                modifier = Modifier.padding(vertical = 16.dp),
                color = ColorUtils.parseColor("#eeeeee")
            )
            CartMenu(
                cart = cart,
                modifier = Modifier.fillMaxWidth()
            )

        }
    }
}