package org.example.kmp_case.core.domain

data class Price(val amount: Double, val currency: Currency) {
    fun getFormattedPrice(): String = "${currency.name} ${String.format("%.2f", amount)}"
}