package org.example.kmp_case.payment.domain

enum class PaymentProcessStatus {
    AwaitingCard,
    ConnectingToProvider,
    VerifyingPayment,
    PaymentSuccessful,
    PaymentFailed,
}