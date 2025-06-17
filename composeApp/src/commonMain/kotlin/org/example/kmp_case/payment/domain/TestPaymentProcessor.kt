package org.example.kmp_case.payment.domain

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.delay

class TestPaymentProcessor: PaymentProcessor {
    private val _isLoading = mutableStateOf(false)
    private val _status = mutableStateOf(PaymentProcessStatus.AwaitingCard)

    override val isLoading: MutableState<Boolean> get() = _isLoading
    override val status: MutableState<PaymentProcessStatus> get() = _status

    override suspend fun process() {
        status.value = PaymentProcessStatus.AwaitingCard
        delay(1500)
        status.value = PaymentProcessStatus.ConnectingToProvider
        delay(1500)
        status.value = PaymentProcessStatus.VerifyingPayment
        delay(1500)
        status.value = PaymentProcessStatus.PaymentSuccessful
        delay(1000)
    }

    override fun getFormattedStatus(): String {
        return when (status.value) {
            PaymentProcessStatus.AwaitingCard -> "Awaiting card..."
            PaymentProcessStatus.ConnectingToProvider -> "Connecting to provider..."
            PaymentProcessStatus.VerifyingPayment -> "Verifying..."
            PaymentProcessStatus.PaymentSuccessful -> "Payment succeeded."
            PaymentProcessStatus.PaymentFailed -> "Payment failed."
        }
    }

}