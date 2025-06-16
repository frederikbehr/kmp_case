package org.example.kmp_case.product.presentation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.kmp_case.core.presentation.NetworkImage
import org.example.kmp_case.product.domain.Product

@Composable
fun ProductButton(
    product: Product,
    onClick: () -> Unit,
    modifier: Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(if (isPressed) 0.9f else 1f)

    Button(
        onClick = onClick,
        interactionSource = interactionSource,
        modifier = modifier.graphicsLayer(scaleX = scale, scaleY = scale),
        colors = ButtonDefaults.buttonColors(containerColor = product.color),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
    ) {
        val showImage: Boolean = product.imageURL != null
        val titleFontSize = 14.sp
        val priceFontSize = 12.sp
        Column(
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = if (!showImage) Arrangement.Bottom else Arrangement.SpaceBetween,
        ) {
            if (showImage) {
                NetworkImage(
                    url = product.imageURL!!, // Nullable image url is forced. Above, its type is checked.
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    contentDescription = null,
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                if (!showImage) {
                    Spacer(modifier = Modifier.weight(1f))
                }
                Text(
                    text = product.name,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium,
                    fontSize = titleFontSize,
                    lineHeight = (titleFontSize.value + 1).sp,
                    modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth(),
                    color = Color.White,
                )
                if (!showImage) {
                    Spacer(modifier = Modifier.weight(1f))
                }
                Text(
                    text = product.price.getFormattedPrice(),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End,
                    fontSize = priceFontSize,
                    lineHeight = (priceFontSize.value + 1).sp,
                    modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth(),
                    color = Color.White.copy(alpha = 0.84f),
                )
            }
        }
    }
}