package org.example.kmp_case.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
actual fun NetworkImage(url: String, contentDescription: String?, modifier: Modifier) {
    AsyncImage(model = url, contentDescription = contentDescription, modifier = modifier)
}