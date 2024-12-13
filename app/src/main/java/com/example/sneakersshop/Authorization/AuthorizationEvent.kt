package com.example.sneakersshop.Authorization

sealed interface AuthorizationEvent {

    object onClick : AuthorizationEvent

    object onClickTextToLogin : AuthorizationEvent

    data class onUsernameTextChanged (val text: String) : AuthorizationEvent
    data class onPasswordTextChanged (val text: String) : AuthorizationEvent
    data class onPasswordRepeatTextChanged (val text: String) : AuthorizationEvent

    data class onUsernameTextFocused (val isFocused: Boolean) : AuthorizationEvent
    data class onPasswordTextFocused (val isFocused: Boolean) : AuthorizationEvent
    data class onPasswordRepeatTextFocused (val isFocused: Boolean) : AuthorizationEvent

}