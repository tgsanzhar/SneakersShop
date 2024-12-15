package com.example.sneakersshop.Fragments.Orders

import android.content.Context
import android.os.Bundle
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.sneakersshop.CurrentUser
import com.example.sneakersshop.R

class OrdersViewModel : ViewModel() {

    var state = mutableStateOf(
        OrdersState(
            list = emptyList()
        )
    )

    fun dispatch(event: OrdersEvent, navController: NavController, context: Context) {
        when(event) {
            is OrdersEvent.ToDetails -> {
                val bundle = Bundle().apply {
                    putInt("id", event.id)
                }
                navController.navigate(R.id.action_ordersFragment_to_orderDetailFragment, bundle)
            }

            OrdersEvent.Back -> navController.navigateUp()
        }
    }

}