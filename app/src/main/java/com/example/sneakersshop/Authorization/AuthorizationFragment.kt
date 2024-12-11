package com.example.sneakersshop.Authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController

class AuthorizationFragment : Fragment() {

    private val viewModel: AuthorizationViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val navController = findNavController()
        return ComposeView(requireContext()).apply {
            setContent {
                AuthorizationScreen (
                    onEvent = { event -> viewModel.dispatch(event, navController) },
                    state = viewModel.state.value
                )
            }
        }
    }
}