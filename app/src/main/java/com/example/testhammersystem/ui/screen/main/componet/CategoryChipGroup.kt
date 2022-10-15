package com.example.testhammersystem.ui.screen.main.componet

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testhammersystem.ui.screen.main.Category
import com.example.testhammersystem.ui.theme.InactiveElement
import com.example.testhammersystem.ui.theme.Primary
import com.example.testhammersystem.ui.theme.ShadowColor
import com.example.testhammersystem.util.drawColoredShadow
import kotlin.reflect.KFunction1

@Composable
fun CategoryChipGroup(
    modifier: Modifier = Modifier,
    listChip: List<Category>,
    selectedChip: String,
    onClickChip: KFunction1<Category, Unit>,
    loadingChip: Category?
) {
    LazyRow(
        modifier = modifier.background(Color.White),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
    ) {

        items(items = listChip) { item ->
            Chip(
                item = item,
                isSelected = selectedChip == item.cat,
                onClick = onClickChip,
                isLoading = loadingChip == item
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Chip(
    modifier: Modifier = Modifier,
    item: Category,
    isSelected: Boolean,
    isLoading: Boolean,
    onClick: (Category) -> Unit,
) {

    val animateBackgroundColor =
        animateColorAsState(
            targetValue = if (isSelected) Primary.copy(
                alpha = 0.3f
            ) else Color.White
        )
    val animateTextColor =
        animateColorAsState(targetValue = if (isSelected) Primary else InactiveElement)

    Card(
        modifier = modifier
            .drawColoredShadow(
                color = if (isSelected) ShadowColor else Color.Transparent,
                borderRadius = 6.dp,
                shadowRadius = 12.dp,
                alpha = 0.05f
            ),
        shape = MaterialTheme.shapes.small,
        onClick = { onClick(item) },
        enabled = !isSelected,
        elevation = 0.dp,
        backgroundColor = animateBackgroundColor.value
    ) {

        Row(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier,
                text = item.cat,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal,
                color = animateTextColor.value
            )
            if (isLoading){
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    strokeWidth = 2.dp,
                    color = Primary
                )
            }
        }

    }
}

@Preview
@Composable
private fun ChipIsSelectedPreview() {
    Chip(
        item = Category.BestFood,
        isSelected = true,
        isLoading = false
    ) {
    }
}

@Preview
@Composable
private fun ChipUnSelectedPreview() {
    Chip(
        item = Category.Burgers,
        isSelected = false,
        isLoading = true
    ) {
    }
}





