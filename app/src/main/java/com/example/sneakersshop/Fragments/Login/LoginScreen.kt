package com.example.sneakersshop.Fragments.Login
import android.media.metrics.Event
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sneakersshop.Fragments.Authorization.AuthorizationEvent
import com.example.sneakersshop.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onEvent: (LoginEvent) -> Unit,
    state: LoginState
) {

    Box(
        Modifier.fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 36.dp)
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
                // USERNAME
                TextField(

                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged {
                            onEvent (LoginEvent.onUsernameTextFocused(it.isFocused))
                        }
                        .border(
                            width = if (state.usernameFocused) 2.dp else (-1).dp,
                            color = Color(0xFF000000),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    value = state.username,
                    onValueChange = {onEvent(LoginEvent.onUsernameTextChanged(it))},
                    singleLine = true,
                    shape = RoundedCornerShape(4.dp),
                    textStyle = TextStyle(
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp,
                    ),

                    colors = TextFieldDefaults.colors().copy(
                        focusedContainerColor = Color(0xFFF6F6F6),
                        unfocusedContainerColor = Color(0xFFF6F6F6),
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
                            onEvent (LoginEvent.onPasswordTextFocused(it.isFocused))
                        }
                        .border(
                            width = if (state.passwordFocused) 2.dp else (-1).dp,
                            color = Color(0xFF000000),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    visualTransformation = PasswordVisualTransformation(),
                    value = state.password,
                    onValueChange = {onEvent(LoginEvent.onPasswordTextChanged(it))},
                    singleLine = true,
                    shape = RoundedCornerShape(4.dp),
                    textStyle = TextStyle(
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp,
                    ),
                    colors = TextFieldDefaults.colors().copy(
                        focusedContainerColor = Color(0xFFF6F6F6),
                        unfocusedContainerColor = Color(0xFFF6F6F6),
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
                // To author
                Text(
                    modifier = Modifier
                        .padding( vertical = 12.dp, horizontal = 4.dp)
                        .fillMaxWidth()
                        .combinedClickable(
                            onClick = { onEvent(LoginEvent.onClickTextToAuthorization) },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ),
                    color = Color(0xFF0000FF),
                    text = "I haven't account!",
                    textAlign = TextAlign.Right,
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
            onClick = { onEvent (LoginEvent.onClick) }
        ) {
            Text(
                text = "Login",
                fontSize = 17.sp,
                fontWeight = FontWeight(600)
            )
        }
    }


}

