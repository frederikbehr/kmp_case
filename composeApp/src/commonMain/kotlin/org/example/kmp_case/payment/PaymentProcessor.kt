package org.example.kmp_case.payment

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

interface PaymentProcessor {
    private val status: MutableState<PaymentProcessStatus> get()
    = mutableStateOf<PaymentProcessStatus>(PaymentProcessStatus.AwaitingCard)

    suspend fun process() {

    }
}