package com.example.sneakersshop.Authorization

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.sneakersshop.R

class AuthorizationViewModel : ViewModel() {

    var state = mutableStateOf(
        AuthorizationState(
            username = "",
            password = "",
            usernameFocused = false,
            passwordFocused = false,
        )
    )

    fun dispatch(event: AuthorizationEvent, navController: NavController) {
        when(event) {
            AuthorizationEvent.onClick -> {
                navController.navigate(R.id.action_home_to_store)
            }

            is AuthorizationEvent.onPasswordTextChanged -> state.value = state.value.copy(password = event.text)
            is AuthorizationEvent.onUsernameTextChanged -> state.value = state.value.copy(username = event.text)
            is AuthorizationEvent.onPasswordTextFocused -> state.value = state.value.copy(passwordFocused = event.isFocused)
            is AuthorizationEvent.onUsernameTextFocused -> state.value = state.value.copy(usernameFocused = event.isFocused)
        }
    }

}