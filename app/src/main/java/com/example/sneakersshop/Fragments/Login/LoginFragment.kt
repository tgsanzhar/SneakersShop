package com.example.sneakersshop.Fragments.Login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.sneakersshop.CurrentUser
import com.example.sneakersshop.R

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val navController = findNavController()
        val sharedPreferences = requireContext().getSharedPreferences("USER", Context.MODE_PRIVATE)
        val id = sharedPreferences.getInt("ID", -1)
        val username = sharedPreferences.getString("USERNAME", "NULL")
        val password = sharedPreferences.getString("PASSWORD", "NULL")
        if(id != -1){
            CurrentUser.id = id
            CurrentUser.username = username?:"NULL"
            CurrentUser.password = password?:"NULL"
            navController.navigate(
                R.id.action_login_to_store,
                null,
                NavOptions.Builder()
                    .setPopUpTo(R.id.nav_graph, true)
                    .build()
            )
        }

        return ComposeView(requireContext()).apply {
            setContent {
                LoginScreen (
                    onEvent = { event -> viewModel.dispatch(event, navController, requireContext()) },
                    state = viewModel.state.value
                )
            }
        }
    }
}