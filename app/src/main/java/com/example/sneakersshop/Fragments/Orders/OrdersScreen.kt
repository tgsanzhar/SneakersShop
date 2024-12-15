package com.example.sneakersshop.Fragments.Orders

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sneakersshop.Fragments.Cart.CartEvent
import com.example.sneakersshop.Fragments.Catalog.CatalogEvent
import com.example.sneakersshop.Fragments.OrderDetail.OrderDetailEvent
import com.example.sneakersshop.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OrdersScreen(modifier: Modifier = Modifier, onEvent: (OrdersEvent) -> Unit, state: OrdersState) {


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
                            onClick = { onEvent( OrdersEvent.Back ) },
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
                    text = "Orders",
                    textAlign = TextAlign.Center,
                    fontSize = 17.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
            }

            LazyColumn(
                modifier = Modifier
                    .padding(top = 22.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                //CARD
                items(state.list) { index ->
                    Row (modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .background(color = Color(0xFFFFFFFF))
                        .combinedClickable(
                            onClick = { onEvent( OrdersEvent.ToDetails(index.id) ) },
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    )
                    ){
                        Image(
                            modifier = Modifier
                                .size(140.dp)
                                .align(Alignment.CenterVertically)
                                .padding(vertical = 10.dp, horizontal = 16.dp),
                            painter = painterResource(R.drawable.img_boot_image),
                            contentDescription = "NULL",
                            contentScale = ContentScale.Fit
                        )

                        Column (
                            modifier = Modifier
                                .padding(end = 18.dp)
                                .padding(vertical = 16.dp)
                                .weight(1f),
                        ) {
                            Text(
                                text = "Order #${index.id}",
                                fontWeight = FontWeight(600),
                                fontSize = 17.sp
                            )
                            Text(
                                modifier = Modifier
                                    .padding(top = 2.dp),
                                text = "${index.createdAt}",
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                                color = Color(0xFF8E8E93)
                            )
                            Text(
                                modifier = Modifier
                                    .padding(top = 12.dp),
                                text = "${index.count} ITEM $${index.sumMoney}",
                                fontWeight = FontWeight(600),
                                fontSize = 12.sp
                            )

                        }

                        Icon(modifier = Modifier
                            .padding(16.dp)
                            .fillMaxHeight()
                            .align(Alignment.CenterVertically),
                            painter = painterResource(R.drawable.chevron),
                            contentDescription = "next"
                        )
                    }
                }
            }
        }
    }
}
