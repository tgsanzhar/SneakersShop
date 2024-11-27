package com.example.sneakersshop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Boots(
    val name: String,
    val category: String,
    val price: String,
)

@Composable
fun CatalogScreen(modifier: Modifier = Modifier) {

    val itemss = listOf (
        Boots("Dolce & Gabbana", "Кеды с принтом граффити", "$1251"),
        Boots("Off-White", "Кроссовки Off-Court 3.0", "1 • $551"),
        Boots("Jordan", "Кеды с принтом граффити", "$1251"),
        Boots("Jordan", "Кеды с принтом граффити", "$1251"),
        Boots("Dolce & Gabbana", "Кеды с принтом граффити", "$1251"),
        Boots("Off-White", "Кроссовки Off-Court 3.0", "1 • $551"),
        Boots("Dolce & Gabbana", "Кеды с принтом граффити", "$1251"),
        Boots("Off-White", "Кроссовки Off-Court 3.0", "1 • $551"),
        Boots("Dolce & Gabbana", "Кеды с принтом граффити", "$1251"),
    )

    Box {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(top = 36.dp),
        ) {
            Text(
                modifier = modifier
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                text = "Hello, Sneakerhead!",
                textAlign = TextAlign.Center,
                fontSize = 17.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
            )
            LazyVerticalGrid(
                modifier = Modifier
                    .padding(bottom = 72.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(8.dp),
                columns = GridCells.Fixed(2),
            ) {
                items(itemss.size) { index ->
                    // CARD
                    Column(
                        modifier = Modifier
                            .size(174.dp, 282.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(4.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .size(166.dp, 166.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            contentScale = ContentScale.Crop,
                            painter = painterResource(R.drawable.img_boot_image),
                            contentDescription = "Image"
                        )
                        Text(
                            modifier = Modifier.padding(2.dp),
                            text = itemss[index].name,
                            fontSize = 13.sp,
                            fontWeight = FontWeight(600)
                        )
                        Text(
                            modifier = Modifier.padding(2.dp),
                            text = itemss[index].category,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF8E8E93)
                        )
                        Text(
                            modifier = Modifier.padding(2.dp),
                            text = itemss[index].price,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(600)
                        )
                        Button(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .fillMaxWidth()
                                .height(36.dp),
                            colors = ButtonColors(
                                containerColor = Color(0xFF000000),
                                contentColor = Color(0xFFFFFFFF),
                                disabledContentColor = Color(0xFF000000),
                                disabledContainerColor = Color(0xFFFFFFFF),
                            ),
                            onClick = {}
                        ) {
                            Text(
                                text = "Add to cart",
                                fontSize = 15.sp,
                                fontWeight = FontWeight(400)
                            )
                        }
                    }
                    // CARD END
                }
            }
        }
        Column(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
                .height(64.dp)
                .align(Alignment.BottomCenter)
                .background(color = Color(0xFFFFFFFF)),
        ) {
            HorizontalDivider()

            Row(
                modifier = Modifier
                    .padding(horizontal = 26.dp)
                    .padding(top = 14.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(76.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        painter = painterResource(R.drawable.ic_icon_home),
                        contentDescription = "Home Icon"
                    )
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        text = "Catalog",
                        fontSize = 10.sp,
                        fontWeight = FontWeight(500)
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(76.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        painter = painterResource(R.drawable.ic_icon_cart),
                        contentDescription = "Cart Icon"
                    )
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        text = "Cart",
                        fontSize = 10.sp,
                        fontWeight = FontWeight(500)
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(76.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        painter = painterResource(R.drawable.ic_icon_profile),
                        contentDescription = "Profile Icon"
                    )
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        text = "Profile",
                        fontSize = 10.sp,
                        fontWeight = FontWeight(500)
                    )
                }
            }
        }


    }


}

