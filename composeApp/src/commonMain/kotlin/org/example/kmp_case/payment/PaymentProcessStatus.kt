package org.example.kmp_case.payment

enum class PaymentProcessStatus {
    AwaitingCard,
    ConnectingToProvider,
    VerifyingPayment,
    PaymentSuccessful,
    PaymentFailed,
}