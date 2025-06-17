package org.example.kmp_case.product_category.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.kmp_case.product_category.domain.ProductCategory

@Composable
fun CategoryButton(
    category: ProductCategory,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 1.dp, horizontal = 12.dp)
            .scale(if (isSelected) 1f else 0.9f).alpha(if (isSelected) 1f else 0.8f),
        colors = ButtonDefaults.buttonColors(
            containerColor = category.color
        ),
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            if (isSelected) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Selected category",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp).padding(end = 8.dp),
                )
            }
            Text(
                text = category.name,
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 16.dp),
                color = Color.White
            )
        }
    }
}