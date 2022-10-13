package com.example.testhammersystem.ui.screen.main.componet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
fun TopAppBar(modifier: Modifier = Modifier) {
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
                text = "Москва",
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
                tint = Color(0xFF323232)
            )
        }

        Icon(
            modifier = Modifier,
            painter = painterResource(id = R.drawable.ic_qr_code),
            contentDescription = null,
            tint = Color(0xFF323232)
        )
    }
}

@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBar()
}