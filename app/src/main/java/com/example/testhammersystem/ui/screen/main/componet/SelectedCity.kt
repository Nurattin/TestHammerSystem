package com.example.testhammersystem.ui.screen.main.componet

import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.testhammersystem.R

@Composable
fun SelectedCity(
    modifier: Modifier = Modifier,
    listCity: List<String>,
    onDismissRequest: () -> Unit,
    onClickCity: (String) -> Unit,
    selectedCity: String,
    expanded: Boolean
) {
    DropdownMenu(
        modifier = modifier,
        expanded = expanded,
        onDismissRequest = { onDismissRequest() }) {

        listCity.forEach { city ->
            DropdownMenuItem(
                onClick = { onClickCity(city) },
                enabled = city != selectedCity
            ) {
                Text(
                    text = city,
                    fontFamily = FontFamily(
                        Font(R.font.roboto_medium, FontWeight.Normal)
                    ),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 18.75.sp
                )
            }
        }

    }
}