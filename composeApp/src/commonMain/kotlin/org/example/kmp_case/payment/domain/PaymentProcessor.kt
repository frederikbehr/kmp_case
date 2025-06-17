package org.example.kmp_case.payment.domain

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

interface PaymentProcessor {
    val isLoading: MutableState<Boolean>
    val status: MutableState<PaymentProcessStatus>

    suspend fun process()
    fun getFormattedStatus(): String
}