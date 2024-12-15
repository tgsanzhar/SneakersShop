package com.example.sneakersshop.Fragments.Cart

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.sneakersshop.CurrentUser
import com.example.sneakersshop.Model.DatabaseProvider
import com.example.sneakersshop.Model.Entity.Order
import com.example.sneakersshop.R
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CartViewModel : ViewModel() {

    var state = mutableStateOf(
        CartState(
            list = emptyList(),
            all_count = 0,
            sum_money = 0,
        )
    )

    fun dispatch(event: CartEvent, navController: NavController, context: Context) {
        when(event) {
            CartEvent.ToCatalog -> {
                navController.navigate(
                    R.id.action_cart_to_catalog,
                    null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.nav_graph, true)
                        .build()
                )
            }
            CartEvent.ToProfile -> {
                navController.navigate(
                    R.id.action_cart_to_profile,
                    null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.nav_graph, true)
                        .build()
                )
            }

            CartEvent.Order -> {
                if(state.value.list.isNotEmpty())
                {
                    viewModelScope.launch {
                        val currentDate = Date()
                        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
                        val formattedDate = dateFormat.format(currentDate)

                        val data = DatabaseProvider.getDatabase(context).orderDao()
                        val order = Order(0, CurrentUser.id, state.value.sum_money, state.value.all_count, formattedDate)
                        val id = data.insert(order)

                        DatabaseProvider.getDatabase(context).cartDao()
                            .updateOrderIds(CurrentUser.id, id)

                        state.value = state.value.copy(list = emptyList(), all_count = 0, sum_money = 0)
                    }
                }
            }

            is CartEvent.MinusCount -> {
                viewModelScope.launch {
                    val data = DatabaseProvider.getDatabase(context).cartDao()
                    var cart = data.getCart(event.id)
                    data.delete(cart)
                    cart.count -= 1
                    if(cart.count > 0)
                    {
                        data.insert(cart)
                    }
                    val carts = data.getAllCartsOfUser(CurrentUser.id)
                    state.value = state.value.copy(list = carts, all_count = state.value.all_count - 1, sum_money = carts.sumOf { it.price * it.count })
                }
            }
            is CartEvent.PlusCount -> {
                viewModelScope.launch {
                    val data = DatabaseProvider.getDatabase(context).cartDao()
                    val cart = data.getCart(event.id)
                    data.delete(cart)
                    cart.count += 1
                    data.insert(cart)
                    val carts = data.getAllCartsOfUser(CurrentUser.id)
                    state.value = state.value.copy(list = carts, all_count = state.value.all_count + 1, sum_money = carts.sumOf { it.price * it.count })
                }
            }

        }
    }

}