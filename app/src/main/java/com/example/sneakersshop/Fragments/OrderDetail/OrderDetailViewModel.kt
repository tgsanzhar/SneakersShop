package com.example.sneakersshop.Fragments.OrderDetail

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.sneakersshop.Model.Entity.Order

class OrderDetailViewModel : ViewModel() {

    var state = mutableStateOf(
        OrderDetailState(
            order = Order(-1, -1, -1, -1, ""),
            list = emptyList()
        )
    )

    fun dispatch(event: OrderDetailEvent, navController: NavController, context: Context) {
        when(event) {
            OrderDetailEvent.Back -> {
                navController.navigateUp()
            }
        }
    }

}