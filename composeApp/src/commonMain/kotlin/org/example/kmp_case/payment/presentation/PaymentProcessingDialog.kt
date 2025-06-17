package org.example.kmp_case.payment.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import org.example.kmp_case.MainViewModel
import org.example.kmp_case.core.domain.ColorUtils
import org.example.kmp_case.payment.domain.PaymentProcessStatus

@Composable
fun PaymentProcessingDialog(viewModel: MainViewModel) {
    if (viewModel.paymentProcessor.isLoading.value) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
                .zIndex(1f),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
                    .padding(all = 32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    if (viewModel.paymentProcessor.status.value != PaymentProcessStatus.PaymentSuccessful) {
                        CircularProgressIndicator(
                            color = ColorUtils.parseColor("#0ca577"),
                            modifier = Modifier
                                .padding(bottom = 16.dp)
                                .size(40.dp)
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Filled.CheckCircle,
                            contentDescription = "Payment Succesful",
                            tint = ColorUtils.parseColor("#0ca577"),
                            modifier = Modifier
                                .padding(bottom = 16.dp)
                                .size(64.dp)
                        )
                    }
                    Text(
                        text = viewModel.paymentProcessor.getFormattedStatus(),
                        color = Color.Gray,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                    )
                }
            }
        }
    }
}