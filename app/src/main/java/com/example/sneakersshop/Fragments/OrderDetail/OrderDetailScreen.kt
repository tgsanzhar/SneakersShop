package com.example.sneakersshop.Fragments.OrderDetail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sneakersshop.Fragments.Catalog.CatalogEvent
import com.example.sneakersshop.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OrderDetailScreen(modifier: Modifier = Modifier, onEvent: (OrderDetailEvent) -> Unit, state: OrderDetailState) {


    Box {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 36.dp),

        ) {
            Row(modifier = Modifier
                .padding(bottom = 12.dp)
                ) {
                Icon(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .align(Alignment.CenterVertically)
                        .combinedClickable(
                            onClick = { onEvent( OrderDetailEvent.Back ) },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        )
                    ,
                    painter = painterResource(R.drawable.ic_icon_left),
                    contentDescription = "Back"
                )
                Text(
                    modifier = modifier
                        .padding(end = 34.dp)
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                    ,
                    text = "Order #${state.order.id}",
                    textAlign = TextAlign.Center,
                    fontSize = 17.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
            }
            // Account Information

            Row (modifier = Modifier
                .padding(top = 26.dp)
                .fillMaxWidth()
                .height(52.dp)
                .background(color = Color(0xFFFFFFFF)),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 16.dp),

                    text = "Ordered",
                    fontWeight = FontWeight(400),
                    fontSize = 17.sp
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = 16.dp),

                    text = state.order.createdAt,
                    fontWeight = FontWeight(600),
                    fontSize = 17.sp
                )
            }

            // Order History

            Row (modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .height(52.dp)
                .background(color = Color(0xFFFFFFFF)),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 16.dp),

                    text = "${state.order.count} items: Total (Including Delivery) ",
                    fontWeight = FontWeight(400),
                    fontSize = 17.sp
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = 16.dp),

                    text = "$${state.order.sumMoney}",
                    fontWeight = FontWeight(600),
                    fontSize = 13.sp
                )

            }

            LazyColumn(
                modifier = Modifier
                    .padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.list) { index ->
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp)
                            .background(color = Color.White)
                    ) {
                        Image(
                            modifier = Modifier
                                .padding(vertical = 10.dp, horizontal = 16.dp)
                                .size(140.dp),
                            painter = painterResource(index.drawable),
                            contentDescription = "Image",
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(top = 44.dp, start = 16.dp)
                                .fillMaxHeight()
                                .fillMaxHeight(),

                        ) {
                            Text(
                                modifier = Modifier,
                                text = index.name,
                                fontWeight = FontWeight(600),
                                fontSize = 13.sp,
                            )
                            Text(
                                modifier = Modifier
                                    .padding(top = 2.dp, bottom = 4.dp),
                                text = index.category,
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                            )
                            Text(
                                modifier = Modifier,
                                text = "${index.count} • \$${index.price * index.count}",
                                fontWeight = FontWeight(600),
                                fontSize = 12.sp,
                            )
                        }
                    }
                }
            }


        }

    }

}

