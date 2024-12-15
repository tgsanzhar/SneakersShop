package com.example.sneakersshop.Fragments.Profile

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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sneakersshop.Fragments.Cart.CartEvent
import com.example.sneakersshop.Fragments.Login.LoginEvent
import com.example.sneakersshop.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileScreen(modifier: Modifier = Modifier, onEvent: (ProfileEvent) -> Unit, state: ProfileState) {


    Box {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 36.dp),
        ) {
            Text(
                modifier = modifier
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                text = "Profile",
                textAlign = TextAlign.Center,
                fontSize = 17.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
            )
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

                    text = "Account Information",
                    fontWeight = FontWeight(400),
                    fontSize = 17.sp
                )
                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = 16.dp),
                    painter = painterResource(R.drawable.chevron),
                    contentDescription = "Right arrow"
                )
            }

            // Order History

            Row (modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .height(52.dp)
                .background(color = Color(0xFFFFFFFF))
                .combinedClickable(
                    onClick = { onEvent( ProfileEvent.ToOrders ) },
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 16.dp),

                    text = "Order History",
                    fontWeight = FontWeight(400),
                    fontSize = 17.sp
                )
                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = 16.dp),
                    painter = painterResource(R.drawable.chevron),
                    contentDescription = "Right arrow"
                )

            }

            // Shoe size

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

                    text = "Shoe size",
                    fontWeight = FontWeight(400),
                    fontSize = 17.sp
                )

                Row (modifier = Modifier
                    .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = "41.5",
                        fontWeight = FontWeight(400),
                        fontSize = 17.sp,
                        color = Color(0xFF8E8E93)
                    )
                    Icon(
                        modifier = Modifier
                            .padding(end = 16.dp, start = 12.dp),
                        painter = painterResource(R.drawable.chevron),
                        contentDescription = "Right arrow"
                    )
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
                        .combinedClickable(
                            onClick = { onEvent( ProfileEvent.ToCatalog ) },
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
                        .combinedClickable(
                            onClick = { onEvent( ProfileEvent.ToCart ) },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        )
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
            onClick = {onEvent(ProfileEvent.SignOut)}
        ) {
            Text(
                text = "Sign Out",
                fontSize = 17.sp,
                fontWeight = FontWeight(600)
            )
        }

    }



}

