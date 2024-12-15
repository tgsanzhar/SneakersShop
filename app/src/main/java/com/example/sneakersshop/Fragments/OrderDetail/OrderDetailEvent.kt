package com.example.sneakersshop.Fragments.OrderDetail

sealed interface OrderDetailEvent {
    data object Back : OrderDetailEvent
}