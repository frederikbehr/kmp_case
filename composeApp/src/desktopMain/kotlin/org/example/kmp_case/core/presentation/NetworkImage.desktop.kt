package org.example.kmp_case.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
actual fun NetworkImage(url: String, contentDescription: String?, modifier: Modifier) {
    // This desktop version uses Kamel for getting and showing images asynchronously.
    val painterResource = asyncPainterResource(data = url)
    KamelImage({ painterResource }, contentDescription = contentDescription, modifier = modifier)
}