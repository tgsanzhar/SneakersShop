package com.example.sneakersshop.Fragments.Profile

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.sneakersshop.CurrentUser
import com.example.sneakersshop.R

class ProfileViewModel : ViewModel() {

    var state = mutableStateOf(
        ProfileState(
            list = emptyList()
        )
    )

    fun dispatch(event: ProfileEvent, navController: NavController, context: Context) {
        when(event) {
            ProfileEvent.ToCatalog -> {
                navController.navigate(
                    R.id.action_profile_to_catalog,
                    null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.nav_graph, true)
                        .build()
                )
            }
            ProfileEvent.ToCart -> {
                navController.navigate(
                    R.id.action_profile_to_cartFragment,
                    null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.nav_graph, true)
                        .build()
                )

            }

            ProfileEvent.SignOut -> {
                CurrentUser.id = -1
                CurrentUser.username = "NULL"
                CurrentUser.password = "NULL"
                val sharedPref = context.getSharedPreferences("USER", Context.MODE_PRIVATE)
                sharedPref.edit()
                    .remove("ID")
                    .remove("USERNAME")
                    .remove("PASSWORD")
                    .apply()
                navController.navigate(R.id.action_profile_to_login,
                    null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.nav_graph, true)
                        .build())
            }

            ProfileEvent.ToOrders -> {
                navController.navigate(R.id.action_profile_to_ordersFragment)

            }
        }
    }

}