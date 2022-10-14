package com.example.testhammersystem.ui.screen.main.componet

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testhammersystem.ui.screen.main.CategoryChip
import com.example.testhammersystem.ui.theme.InactiveElement
import com.example.testhammersystem.ui.theme.Primary
import com.example.testhammersystem.ui.theme.ShadowColor
import com.example.testhammersystem.util.drawColoredShadow

@Composable
fun CategoryChipGroup(
    modifier: Modifier = Modifier,
    listChip: List<CategoryChip>,
    selectedChip: CategoryChip?,
    onClickChip: (CategoryChip) -> Unit
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(start = 16.dp)
    ) {

        items(items = listChip) { item ->
            Chip(
                item = item,
                isSelected = if (selectedChip == null) false else selectedChip == item,
                onClick = onClickChip
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Chip(
    modifier: Modifier = Modifier,
    item: CategoryChip,
    isSelected: Boolean,
    onClick: (CategoryChip) -> Unit
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
        elevation = 0.dp,
        backgroundColor = animateBackgroundColor.value
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 20.dp),
            text = item.title,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal,
            color = animateTextColor.value
        )
    }
}

@Preview
@Composable
private fun ChipIsSelectedPreview() {
    Chip(
        item = CategoryChip(
            id = 1, "Пицца"
        ),
        isSelected = true
    ) {
    }
}

@Preview
@Composable
private fun ChipUnSelectedPreview() {
    Chip(
        item = CategoryChip(
            id = 1, "Пицца"
        ),
        isSelected = false
    ) {
    }
}





