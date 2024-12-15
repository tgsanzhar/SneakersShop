package com.example.sneakersshop.Fragments.OrderDetail

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
import kotlinx.coroutines.launch

class OrderDetailFragment : Fragment() {

    private val viewModel: OrderDetailViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val navController = findNavController()

        lifecycleScope.launch {
            val orderId = arguments?.getInt("id") ?: -1
            val data = DatabaseProvider.getDatabase(requireContext())
            val order = data.orderDao().getOrder(orderId)
            val carts = data.cartDao().getAllCartsOfOrder(orderId)
            viewModel.state.value = viewModel.state.value.copy(order = order, list = carts)
        }

        return ComposeView(requireContext()).apply {
            setContent {
                OrderDetailScreen(
                    state = viewModel.state.value,
                    onEvent = { event -> viewModel.dispatch(event, navController, requireContext() ) }
                )
            }
        }
    }
}