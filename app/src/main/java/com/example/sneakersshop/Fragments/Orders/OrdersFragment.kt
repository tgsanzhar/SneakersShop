package com.example.sneakersshop.Fragments.Orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.sneakersshop.CurrentUser
import com.example.sneakersshop.Model.DatabaseProvider
import com.example.sneakersshop.Model.Entity.Boot
import com.example.sneakersshop.R
import kotlinx.coroutines.launch

class OrdersFragment : Fragment() {

    private val viewModel: OrdersViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val navController = findNavController()

        lifecycleScope.launch {
            val data = DatabaseProvider.getDatabase(requireContext()).orderDao()
            val orders = data.getAllOrdersOfUser(CurrentUser.id)
            viewModel.state.value = viewModel.state.value.copy(list = orders)
        }

        return ComposeView(requireContext()).apply {
            setContent {
                OrdersScreen(
                    state = viewModel.state.value,
                    onEvent = { event -> viewModel.dispatch(event, navController, requireContext() ) }
                )
            }
        }
    }
}