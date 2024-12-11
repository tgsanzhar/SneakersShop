package com.example.sneakersshop.Authorization

sealed interface AuthorizationEvent {

    object onClick : AuthorizationEvent
    data class onUsernameTextChanged (val text: String) : AuthorizationEvent
    data class onPasswordTextChanged (val text: String) : AuthorizationEvent

    data class onUsernameTextFocused (val isFocused: Boolean) : AuthorizationEvent
    data class onPasswordTextFocused (val isFocused: Boolean) : AuthorizationEvent

}