package org.example.kmp_case.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun NetworkImage(url: String, contentDescription: String?, modifier: Modifier)
// NetworkImage is expected to work for Android and Desktop with their own implementations.
