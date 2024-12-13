package com.example.sneakersshop.Authorization

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.sneakersshop.Model.DatabaseProvider
import com.example.sneakersshop.Model.Entity.User
import com.example.sneakersshop.R
import kotlinx.coroutines.launch


class AuthorizationViewModel : ViewModel() {



    var state = mutableStateOf(
        AuthorizationState(
            username = "",
            password = "",
            passwordRepeat = "",
            usernameFocused = false,
            passwordFocused = false,
            passwordRepeatFocused = false,
        )
    )

    fun dispatch(event: AuthorizationEvent, navController: NavController, context: Context) {
        when(event) {
            AuthorizationEvent.onClick -> {
                if(state.value.password.isEmpty() || state.value.username.isEmpty()){
                    Toast.makeText(context, "Username or password is empty. Please try again.", Toast.LENGTH_SHORT).show()
                    return
                }
                if(state.value.password != state.value.passwordRepeat){
                    Toast.makeText(context, "Passwords do not match. Please try again.", Toast.LENGTH_SHORT).show()
                    return
                }
                viewModelScope.launch {

                    val user = DatabaseProvider.getDatabase(context).userDao().getAllUsers()
                    var have_nickname = false;
                    for (data in user){
                        if (state.value.username == data.username) {
                            have_nickname = true;
                            Toast.makeText(context, "Nickname is busy. Use another nickname", Toast.LENGTH_SHORT).show()
                            break
                        }
                    }

                    if (!have_nickname){
                        viewModelScope.launch {

                            val user = User(username = state.value.username, password = state.value.password)
                            DatabaseProvider.getDatabase(context).userDao().insert(user)
                        }
                        navController.navigate(R.id.action_authorization_to_store)

                    }

                }

            }

            is AuthorizationEvent.onPasswordTextChanged -> state.value = state.value.copy(password = event.text)
            is AuthorizationEvent.onUsernameTextChanged -> state.value = state.value.copy(username = event.text)
            is AuthorizationEvent.onPasswordTextFocused -> state.value = state.value.copy(passwordFocused = event.isFocused)
            is AuthorizationEvent.onUsernameTextFocused -> state.value = state.value.copy(usernameFocused = event.isFocused)

            is AuthorizationEvent.onPasswordRepeatTextChanged -> state.value = state.value.copy(passwordRepeat = event.text)
            is AuthorizationEvent.onPasswordRepeatTextFocused -> state.value = state.value.copy(passwordRepeatFocused = event.isFocused)

            AuthorizationEvent.onClickTextToLogin -> {

                navController.navigate(R.id.action_authorization_to_login)
            }
        }
    }

}