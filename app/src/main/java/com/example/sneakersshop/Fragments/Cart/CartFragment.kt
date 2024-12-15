package com.example.sneakersshop.Fragments.Cart

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

class CartFragment : Fragment() {

    private val viewModel: CartViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val navController = findNavController()

        lifecycleScope.launch {
            val data = DatabaseProvider.getDatabase(requireContext()).cartDao()
            val carts = data.getAllCartsOfUser(CurrentUser.id)

            viewModel.state.value = viewModel.state.value.copy(list = carts, all_count = carts.sumOf { it.count }, sum_money = carts.sumOf { it.price * it.count })
        }

        return ComposeView(requireContext()).apply {
            setContent {
                CartScreen(
                    state = viewModel.state.value,
                    onEvent = { event -> viewModel.dispatch(event, navController, requireContext() ) }
                )
            }
        }
    }
}