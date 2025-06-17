package org.example.kmp_case.product_category.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.NoAccounts
import androidx.compose.material.icons.filled.SwitchAccount
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.kmp_case.MainViewModel
import org.example.kmp_case.core.domain.ColorUtils
import org.example.kmp_case.product_category.domain.ProductCategory

@Composable
fun CategoryMenu(
    viewModel: MainViewModel,
    onClick: (ProductCategory?) -> Unit,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .drawBehind {
                val strokeWidth = 4f
                drawLine(
                    color = ColorUtils.parseColor("#dfdfdf"),
                    start = Offset(size.width - strokeWidth / 2, 0f),
                    end = Offset(size.width - strokeWidth / 2, size.height),
                    strokeWidth = strokeWidth
                )
            }
    ) {
        Column {
            Button(
                onClick = {  },
                modifier = Modifier
                    .windowInsetsPadding(WindowInsets.safeDrawing.only(WindowInsetsSides.Top))
                    .padding(horizontal = 12.dp)
                    .padding(top = 12.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorUtils.parseColor("#eeeeee"),
                    contentColor = Color.Gray,
                ),
            ) {
                Icon(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = "Sign in",
                    modifier = Modifier.size(22.dp).padding(end = 8.dp),
                )
                Text(
                    text = "Signed in", // for simulation purposes
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                )
            }
            HorizontalDivider(
                thickness = 2.dp,
                modifier = Modifier.padding(12.dp),
                color = ColorUtils.parseColor("#ededed")
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(top = 0.dp),
                contentPadding = PaddingValues(bottom = 32.dp)
            ) {
                items(viewModel.categories) { category ->
                    CategoryButton(
                        category = category,
                        isSelected = viewModel.selectedCategory == category,
                        onClick = { onClick(category) },
                    )
                }
            }
        }
    }
}