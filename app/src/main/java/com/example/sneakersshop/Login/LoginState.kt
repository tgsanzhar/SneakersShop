package com.example.sneakersshop.Login

data class LoginState(
    val username: String,
    val password: String,
    val usernameFocused: Boolean,
    val passwordFocused: Boolean,
)