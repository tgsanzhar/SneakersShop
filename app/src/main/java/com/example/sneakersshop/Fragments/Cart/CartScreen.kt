package com.example.sneakersshop.Fragments.Cart

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.example.sneakersshop.Fragments.Authorization.AuthorizationEvent
import com.example.sneakersshop.Fragments.Profile.ProfileEvent
import com.example.sneakersshop.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CartScreen(modifier: Modifier = Modifier, onEvent: (CartEvent) -> Unit, state: CartState) {


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
            LazyColumn (
                modifier = Modifier
                    .padding(bottom = 72.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(8.dp),
            ) {

                items(state.list.size) { index ->
                    // CARD
                    Row (modifier = Modifier
                        .height(160.dp)
                        .fillMaxWidth()
                        .background(color = Color(0xFFFFFFFF)),
                        horizontalArrangement = Arrangement.Absolute.SpaceBetween
                    ){
                        Image(
                            modifier = Modifier
                                .size(140.dp)
                                .align(Alignment.CenterVertically)
                                .padding(vertical = 10.dp, horizontal = 16.dp),
                            painter = painterResource(state.list[index].drawable),
                            contentDescription = "NULL",
                            contentScale = ContentScale.Fit
                        )

                        Column (
                            modifier = Modifier
                                .padding(end = 18.dp)
                                .padding(vertical = 21.dp),
                        ) {
                            Text(
                                text = state.list[index].name,
                                fontWeight = FontWeight(600),
                                fontSize = 13.sp
                            )
                            Text(
                                modifier = Modifier
                                    .padding(top = 4.dp),
                                text = state.list[index].category,
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                                color = Color(0xFF8E8E93)
                            )
                            Text(
                                modifier = Modifier
                                    .padding(top = 4.dp),
                                text = state.list[index].priceText,
                                fontWeight = FontWeight(600),
                                fontSize = 12.sp
                            )
                            Button(
                                modifier = Modifier
                                    .padding(top = 12.dp, end = 34.dp)
                                    .fillMaxWidth()
                                    .height(36.dp)
                                    .align(Alignment.CenterHorizontally),
                                onClick = {},
                                colors = ButtonDefaults.buttonColors().copy(containerColor = Color.Black)
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .combinedClickable(
                                            onClick = { onEvent( CartEvent.MinusCount(state.list[index].id) ) },
                                            indication = null,
                                            interactionSource = remember { MutableInteractionSource() }
                                        ),
                                    painter = painterResource(R.drawable.subtract),
                                    contentDescription = "substract"
                                )
                                Text(
                                    modifier = Modifier
                                        .padding(horizontal = 8.dp),
                                    text = "${state.list[index].count}"
                                )
                                Icon(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .combinedClickable(
                                            onClick = { onEvent( CartEvent.PlusCount(state.list[index].id) ) },
                                            indication = null,
                                            interactionSource = remember { MutableInteractionSource() }
                                        ),
                                    painter = painterResource(R.drawable.add),
                                    contentDescription = "add"
                                )
                            }
                        }

                    }
                    // CARD END
                }

                item {
                    Row (
                        modifier = Modifier
                            .padding(bottom = 84.dp)
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(color = Color.White),
                        horizontalArrangement = Arrangement.Absolute.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(horizontal = 16.dp),
                            text = "${state.all_count} items: Total (Including Delivery)",
                            fontWeight = FontWeight(400),
                            fontSize = 13.sp,
                        )
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(horizontal = 16.dp),
                            text = "\$${state.sum_money}",
                            fontWeight = FontWeight(600),
                            fontSize = 13.sp,
                        )
                    }
                }



            }
        }








        Button(
            modifier = Modifier
                .padding(bottom = 72.dp)
                .padding(horizontal = 16.dp)
                .safeDrawingPadding()
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(54.dp),
            shape = RoundedCornerShape(32.dp),
            colors = ButtonColors(
                containerColor = Color(0xFF000000),
                disabledContentColor = Color(0xFF000000),
                contentColor = Color(0xFFFFFFFF),
                disabledContainerColor = Color(0xFFFFFFFF),
            ),
            onClick = { onEvent( CartEvent.Order ) }
        ) {
            Text(
                text = "Confirm Order",
                fontSize = 17.sp,
                fontWeight = FontWeight(600)
            )
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
                        .combinedClickable(
                            onClick = { onEvent( CartEvent.ToCatalog ) },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        )
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
                        .combinedClickable(
                            onClick = { onEvent( CartEvent.ToProfile ) },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        )

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

