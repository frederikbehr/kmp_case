package org.example.kmp_case.cart_item.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.kmp_case.cart_item.domain.CartItem

@Composable
fun CartItemView(item: CartItem, onRemoveItem: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f).padding(end = 12.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = item.quantity.toString(),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        color = Color.Black.copy(alpha = 0.87f),
                        modifier = Modifier.padding(end = 12.dp)
                    )
                    Text(
                        text = item.product.name,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        lineHeight = 15.sp,
                        color = Color.Black.copy(alpha = 0.87f),
                    )
                }
                Text(
                    text = item.getTotalPrice.getFormattedPrice(),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp,
                    color = Color.Black.copy(alpha = 0.87f),
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
            IconButton(
                onClick = onRemoveItem,
                colors = IconButtonColors(
                    containerColor = Color.Red.copy(alpha = 0.12f),
                    contentColor = Color.Red,
                    disabledContainerColor = Color.LightGray,
                    disabledContentColor = Color.Gray,
                ),
            ) {
                Icon(
                    imageVector = Icons.Filled.Remove,
                    contentDescription = "Remove",
                    modifier = Modifier.size(18.dp),
                )
            }
        }
    }
}