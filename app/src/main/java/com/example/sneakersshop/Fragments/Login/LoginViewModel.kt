package com.example.sneakersshop.Fragments.Login

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.sneakersshop.Model.DatabaseProvider
import com.example.sneakersshop.Model.Entity.User
import com.example.sneakersshop.R
import kotlinx.coroutines.launch
import com.example.sneakersshop.CurrentUser

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
                                CurrentUser.id = data.id
                                CurrentUser.username = data.username
                                CurrentUser.password = data.password

                                val sharedPreferences = context.getSharedPreferences("USER", Context.MODE_PRIVATE)
                                sharedPreferences.edit()
                                    .putInt("ID", data.id)
                                    .putString("USERNAME", data.username)
                                    .putString("PASSWORD", data.password)
                                    .apply()

                                navController.navigate(
                                    R.id.action_login_to_store,
                                    null,
                                    NavOptions.Builder()
                                        .setPopUpTo(R.id.nav_graph, true)
                                        .build()
                                )
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
                navController.navigate(
                    R.id.action_login_to_authorization,
                    null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.nav_graph, true)
                        .build()
                )
            }

        }
    }

}