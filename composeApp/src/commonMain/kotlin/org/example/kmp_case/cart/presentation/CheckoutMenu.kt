package org.example.kmp_case.cart.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeleteSweep
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.kmp_case.MainViewModel
import org.example.kmp_case.core.domain.ColorUtils

@Composable
fun CheckoutMenu(modifier: Modifier, viewModel: MainViewModel) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .drawBehind {
                drawLine(
                    color = ColorUtils.parseColor("#dfdfdf"),
                    start = Offset(0f, 0f),
                    end = Offset(0f, size.height),
                    strokeWidth = 4f
                )
            }
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .windowInsetsPadding(WindowInsets.safeDrawing.only(WindowInsetsSides.Top))
                    .padding(top = 12.dp)
                    .fillMaxWidth(),
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
                    enabled = viewModel.cart.cart.isNotEmpty(),
                    onClick = { viewModel.cart.clear() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red.copy(alpha = 0.12f),
                        contentColor = Color.Red,
                        disabledContainerColor = ColorUtils.parseColor("#ededed"),
                        disabledContentColor = Color.LightGray,
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.DeleteSweep,
                        contentDescription = "Clear",
                        modifier = Modifier.size(24.dp).padding(end = 4.dp),
                    )
                    Text(
                        text = "Clear",
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                    )
                }
            }
            HorizontalDivider(
                thickness = 2.dp,
                modifier = Modifier.padding(vertical = 16.dp),
                color = ColorUtils.parseColor("#eeeeee")
            )
            CartMenu(
                cart = viewModel.cart,
                modifier = Modifier.weight(1f)
            )
            HorizontalDivider(
                thickness = 2.dp,
                modifier = Modifier.padding(vertical = 16.dp),
                color = ColorUtils.parseColor("#eeeeee")
            )
            Box(
                modifier = Modifier.fillMaxWidth().height(100.dp)
            ) {
                Column {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Total",
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Start,
                            fontSize = 20.sp,
                            color = Color.Black.copy(alpha = 0.87f),
                            modifier = Modifier.padding(bottom = 12.dp)
                        )
                        Text(
                            text = viewModel.cart.getTotalPrice().getFormattedPrice(),
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Start,
                            fontSize = 20.sp,
                            color = Color.Black.copy(alpha = 0.87f),
                            modifier = Modifier.padding(bottom = 12.dp)
                        )
                    }
                    Button(
                        enabled = viewModel.cart.cart.isNotEmpty(),
                        onClick = { viewModel.pay() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = ColorUtils.parseColor("#0ca577"),
                            contentColor = Color.White,
                            disabledContainerColor = ColorUtils.parseColor("#ededed"),
                            disabledContentColor = Color.LightGray,
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Payment,
                            contentDescription = "Pay",
                            modifier = Modifier.size(22.dp).padding(end = 4.dp),
                        )
                        Text(
                            text = "Pay",
                            fontWeight = FontWeight.Medium,
                            fontSize = 15.sp,
                        )
                    }
                }
            }
        }
    }
}