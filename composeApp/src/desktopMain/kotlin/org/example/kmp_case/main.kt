package org.example.kmp_case

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "mPOS",
    ) {
        App()
    }
}