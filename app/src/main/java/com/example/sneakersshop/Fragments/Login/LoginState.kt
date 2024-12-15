package com.example.sneakersshop.Fragments.Login

data class LoginState(
    val username: String,
    val password: String,
    val usernameFocused: Boolean,
    val passwordFocused: Boolean,
)