package com.example.sneakersshop.Authorization

data class AuthorizationState(
    val username: String,
    val password: String,
    val usernameFocused: Boolean,
    val passwordFocused: Boolean,
)