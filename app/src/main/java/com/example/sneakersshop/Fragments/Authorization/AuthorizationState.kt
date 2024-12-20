package com.example.sneakersshop.Fragments.Authorization

data class AuthorizationState(
    val username: String,
    val password: String,

    val passwordRepeat: String,
    val usernameFocused: Boolean,
    val passwordFocused: Boolean,

    val passwordRepeatFocused: Boolean,
)