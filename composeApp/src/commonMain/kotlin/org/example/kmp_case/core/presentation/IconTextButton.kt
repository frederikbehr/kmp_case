package org.example.kmp_case.core.presentation
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun IconTextButton(
    modifier: Modifier = Modifier,
    colors: ButtonColors,
    icon: ImageVector,
    text: String,
    iconSize: Dp,
    fontSize: TextUnit,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    Button(
        enabled = enabled,
        onClick = onClick,
        modifier = modifier,
        colors = colors,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            modifier = Modifier.size(iconSize).padding(end = 8.dp),
        )
        Text(
            text = text, // for simulation purposes
            fontWeight = FontWeight.Medium,
            fontSize = fontSize,
        )
    }
}