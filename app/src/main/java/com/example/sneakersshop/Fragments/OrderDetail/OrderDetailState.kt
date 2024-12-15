package com.example.sneakersshop.Fragments.OrderDetail

import com.example.sneakersshop.Model.Entity.Cart
import com.example.sneakersshop.Model.Entity.Order

data class OrderDetailState(
    val order: Order,
    var list: List<Cart>
)

