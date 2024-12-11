package com.example.sneakersshop.Login

sealed interface LoginEvent {

    object onClick : LoginEvent
    data class onUsernameTextChanged (val text: String) : LoginEvent
    data class onPasswordTextChanged (val text: String) : LoginEvent

    data class onUsernameTextFocused (val isFocused: Boolean) : LoginEvent
    data class onPasswordTextFocused (val isFocused: Boolean) : LoginEvent

}