package com.example.sneakersshop.Login

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.sneakersshop.R

class LoginViewModel : ViewModel() {

    var state = mutableStateOf(
        LoginState(
            username = "",
            password = "",
            usernameFocused = false,
            passwordFocused = false,
        )
    )

    fun dispatch(event: LoginEvent, navController: NavController) {
        when(event) {
            LoginEvent.onClick -> {
                navController.navigate(R.id.action_home_to_store)
            }

            is LoginEvent.onPasswordTextChanged -> state.value = state.value.copy(password = event.text)
            is LoginEvent.onUsernameTextChanged -> state.value = state.value.copy(username = event.text)
            is LoginEvent.onPasswordTextFocused -> state.value = state.value.copy(passwordFocused = event.isFocused)
            is LoginEvent.onUsernameTextFocused -> state.value = state.value.copy(usernameFocused = event.isFocused)
        }
    }

}