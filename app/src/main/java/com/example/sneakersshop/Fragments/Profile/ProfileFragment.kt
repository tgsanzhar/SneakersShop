package com.example.sneakersshop.Fragments.Profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

class ProfileFragment : Fragment() {

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val navController = findNavController()


        return ComposeView(requireContext()).apply {
            setContent {
                ProfileScreen(
                    state = viewModel.state.value,
                    onEvent = { event -> viewModel.dispatch(event, navController, requireContext() ) }
                )
            }
        }
    }
}