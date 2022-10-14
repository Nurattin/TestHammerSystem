package com.example.testhammersystem.ui.screen.main.componet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testhammersystem.R

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    onClickQrCode: () -> Unit,
    selectCity: String,
    onClickDropDown: () -> Unit,
    listCity: List<String>,
    onDismissRequest: () -> Unit,
    onClickCity: (String) -> Unit,
    dropDownExpanded: Boolean
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = selectCity,
                fontFamily = FontFamily(
                    Font(R.font.roboto_medium, FontWeight.Medium)
                ),
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 18.75.sp
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_drop),
                contentDescription = null,
                tint = Color(0xFF323232),
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(radius = 22.dp),
                    onClick = onClickDropDown
                )
            )
            SelectedCity(
                modifier = Modifier.align(Alignment.Bottom),
                listCity = listCity,
                onDismissRequest = onDismissRequest,
                onClickCity = onClickCity,
                selectedCity = selectCity,
                expanded = dropDownExpanded
            )

        }

        Icon(
            modifier = Modifier
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(radius = 22.dp),
                    onClick = onClickQrCode
                ),
            painter = painterResource(id = R.drawable.ic_qr_code),
            contentDescription = null,
            tint = Color(0xFF323232)
        )
    }
}

@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBar(
        onClickQrCode = {},
        selectCity = "Москва",
        onClickDropDown = {},
        onDismissRequest = {},
        onClickCity = {},
        listCity = listOf(
            "Москва",
            "Махачкала"
        ),
        dropDownExpanded = false
    )
}