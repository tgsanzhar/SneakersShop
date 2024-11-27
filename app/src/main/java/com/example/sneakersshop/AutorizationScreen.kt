package com.example.sneakersshop

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthorizationScreen(modifier: Modifier = Modifier, onClickAct: () -> Unit) {

    val textFirstInput = remember { mutableStateOf("") }
    val textSecondInput = remember { mutableStateOf("") }
    val textFieldFirst = remember { mutableStateOf(false) }
    val textFieldSecond = remember { mutableStateOf(false) }
    Box(
        Modifier.fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Column {
            Box (
                Modifier
                    .fillMaxWidth()
                    .height(42.dp)
                    .align(Alignment.CenterHorizontally),
            ){

                Icon(
                    modifier = modifier.align(Alignment.CenterStart)
                        .size(18.dp, 24.dp),
                    painter = painterResource(R.drawable.ic_icon_left),
                    contentDescription = "Icon"
                )

                Text(
                    modifier = modifier.align(Alignment.Center),
                    text = "Welcome back!",
                    textAlign = TextAlign.Center,
                    fontSize = 17.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )

            }

            Column (modifier = Modifier.padding(top = 52.dp)) {
                TextField(

                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged {
                            textFieldFirst.value = it.isFocused
                        }
                        .border(
                            width = if (textFieldFirst.value) 2.dp else (-1).dp,
                            color = Color(0xFF000000),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    value = textFirstInput.value,
                    onValueChange = {it -> textFirstInput.value = it},
                    singleLine = true,
                    shape = RoundedCornerShape(4.dp),
                    textStyle = TextStyle(
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp,
                    ),

                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xFFF6F6F6),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),

                    placeholder = {
                        Text(
                            text = "Username",
                            fontWeight = FontWeight(400),
                            fontSize = 16.sp,
                            color = Color(0xFF8E8E93)
                        )
                    }


                )
                Spacer(
                    modifier = Modifier.padding(8.dp)
                )
                TextField(
                    modifier = Modifier.fillMaxWidth()
                        .onFocusChanged {
                            textFieldSecond.value = it.isFocused
                        }
                        .border(
                            width = if (textFieldSecond.value) 2.dp else (-1).dp,
                            color = Color(0xFF000000),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    visualTransformation = PasswordVisualTransformation(),
                    value = textSecondInput.value,
                    onValueChange = {it -> textSecondInput.value = it},
                    singleLine = true,
                    shape = RoundedCornerShape(4.dp),
                    textStyle = TextStyle(
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp,
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xFFF6F6F6),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),

                    placeholder = {
                        Text(
                            text = "Password",
                            fontWeight = FontWeight(400),
                            fontSize = 16.sp,
                            color = Color(0xFF8E8E93)
                        )
                    }
                )
            }
        }

        Button(
            modifier = Modifier
                .safeDrawingPadding()
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp)
                .height(54.dp),
            shape = RoundedCornerShape(32.dp),
            colors = ButtonColors(
                containerColor = Color(0xFF000000),
                disabledContentColor = Color(0xFF000000),
                contentColor = Color(0xFFFFFFFF),
                disabledContainerColor = Color(0xFFFFFFFF),
            ),
            onClick = { onClickAct() }
        ) {
            Text(
                text = "Sign In",
                fontSize = 17.sp,
                fontWeight = FontWeight(600)
            )
        }
    }


}

