package com.example.sneakersshop.Login

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.sneakersshop.Model.DatabaseProvider
import com.example.sneakersshop.Model.Entity.User
import com.example.sneakersshop.R
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    var state = mutableStateOf(
        LoginState(
            username = "",
            password = "",
            usernameFocused = false,
            passwordFocused = false,
        )
    )

    fun dispatch(event: LoginEvent, navController: NavController, context: Context) {
        when(event) {
            LoginEvent.onClick -> {

                viewModelScope.launch {

                    val user = DatabaseProvider.getDatabase(context).userDao().getAllUsers()
                    var have_username = false
                    for (data in user){
                        if (state.value.username == data.username) {
                            if (state.value.password == data.password){
                                navController.navigate(R.id.action_login_to_store)
                            }
                            else{
                                Toast.makeText(context, "Password isn't correct.", Toast.LENGTH_SHORT).show()
                            }
                            have_username = true
                        }
                    }
                    if (!have_username)
                        Toast.makeText(context, "Username does not exist.", Toast.LENGTH_SHORT).show()

                }
            }

            is LoginEvent.onPasswordTextChanged -> state.value = state.value.copy(password = event.text)
            is LoginEvent.onUsernameTextChanged -> state.value = state.value.copy(username = event.text)
            is LoginEvent.onPasswordTextFocused -> state.value = state.value.copy(passwordFocused = event.isFocused)
            is LoginEvent.onUsernameTextFocused -> state.value = state.value.copy(usernameFocused = event.isFocused)
            LoginEvent.onClickTextToAuthorization -> {
                navController.navigate(R.id.action_login_to_authorization)
            }

        }
    }

}