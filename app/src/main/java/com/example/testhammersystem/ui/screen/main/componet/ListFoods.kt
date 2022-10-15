package com.example.testhammersystem.ui.screen.main.componet

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.testhammersystem.R
import com.example.testhammersystem.domain.model.Food
import com.example.testhammersystem.ui.theme.InactiveElement
import com.example.testhammersystem.ui.theme.Primary
import com.example.testhammersystem.ui.theme.PrimaryText
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer


@Composable
fun FoodDetail(
    modifier: Modifier = Modifier,
    food: Food? = null,
    isLoading: Boolean = false
) {

    when (isLoading) {
        true -> {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(22.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(135.dp)
                        .clip(MaterialTheme.shapes.small)
                        .placeholder(
                            visible = true,
                            color = InactiveElement,
                            shape = MaterialTheme.shapes.small,
                            highlight = PlaceholderHighlight.shimmer(
                                highlightColor = Color.White,
                            ),
                        ),
                )
                Column(
                    modifier = Modifier
                        .height(135.dp)
                        .fillMaxWidth(1f),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.Start)
                            .fillMaxWidth(0.6f)
                            .height(20.dp)
                            .placeholder(
                                visible = true,
                                color = InactiveElement,
                                shape = RoundedCornerShape(4.dp),
                                highlight = PlaceholderHighlight.shimmer(
                                    highlightColor = Color.White,
                                ),
                            )
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(3.dp)
                    ) {
                        repeat(3){
                            Box(
                                modifier = Modifier
                                    .align(Alignment.Start)
                                    .fillMaxWidth(1f/(1..3).random())
                                    .height(15.dp)
                                    .placeholder(
                                        visible = true,
                                        color = InactiveElement,
                                        shape = RoundedCornerShape(4.dp),
                                        highlight = PlaceholderHighlight.shimmer(
                                            highlightColor = Color.White,
                                        ),
                                    )
                            )
                        }
                    }

                }
            }
        }
        false -> {
            food?.let {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .clickable { }
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(22.dp)
                ) {
                    AsyncImage(
                        model = food.img,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(135.dp)
                            .clip(MaterialTheme.shapes.small),
                        placeholder = painterResource(id = R.drawable.ic_placeholder),
                        error = painterResource(id = R.drawable.ic_placeholder)
                    )
                    Column(
                        modifier = Modifier
                            .height(135.dp)
                            .weight(1f),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.Start),
                            text = food.name,
                            style = MaterialTheme.typography.subtitle1,
                            color = PrimaryText,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,

                            )
                        Text(
                            text = food.dsc,
                            maxLines = 4,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.subtitle2,
                            color = InactiveElement,
                            textAlign = TextAlign.Justify
                        )
                        OutlinedButton(
                            modifier = Modifier
                                .height(32.dp)
                                .align(Alignment.End),
                            border = BorderStroke(1.dp, Primary),
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = Primary,
                                backgroundColor = Color.White
                            )
                        ) {
                            Text(
                                text = "от ${food.price.toInt()} р",
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodDetailPreview() {
    FoodDetail(
        food = Food(
            name = "Ветчина и грибы",
            dsc = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
            img = "https://proprikol.ru/wp-content/uploads/2020/11/kartinki-piczcza-40.jpeg",
            id = "1",
            price = 345.0
        )
    )
}