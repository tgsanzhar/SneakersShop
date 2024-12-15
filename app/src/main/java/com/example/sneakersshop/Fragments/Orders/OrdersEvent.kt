package com.example.sneakersshop.Fragments.Orders

sealed interface OrdersEvent {
    data class ToDetails(val id: Int) : OrdersEvent
    data object Back : OrdersEvent
}