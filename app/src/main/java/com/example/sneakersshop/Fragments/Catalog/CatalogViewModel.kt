package com.example.sneakersshop.Fragments.Catalog

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.sneakersshop.CurrentUser
import com.example.sneakersshop.Fragments.Login.LoginEvent
import com.example.sneakersshop.Model.DatabaseProvider
import com.example.sneakersshop.Model.Entity.Cart
import com.example.sneakersshop.R
import kotlinx.coroutines.launch

class CatalogViewModel : ViewModel() {

    var state = mutableStateOf(
        CatalogState(
            list = emptyList()
        )
    )

    fun dispatch(event: CatalogEvent, navController: NavController, context: Context) {
        when(event) {
            is CatalogEvent.onClickToBuy -> {
                viewModelScope.launch {
                    val cart = Cart(
                        id = 0,
                        name = state.value.list[event.id-1].name,
                        category = state.value.list[event.id-1].category,
                        price = state.value.list[event.id-1].price,
                        priceText = state.value.list[event.id-1].priceText,
                        drawable = state.value.list[event.id-1].drawable,
                        userId = CurrentUser.id,
                        orderId = -1,
                        count = 1
                    )
                    DatabaseProvider.getDatabase(context).cartDao().insert(cart)
                }

            }

            CatalogEvent.ToCart -> {
                navController.navigate(
                    R.id.action_catalog_to_cartFragment,
                    null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.nav_graph, true)
                        .build()
                )
            }
            CatalogEvent.ToProfile -> {
                navController.navigate(
                    R.id.action_catalog_to_profileFragment,
                    null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.nav_graph, true)
                        .build()
                )
            }
        }
    }

}