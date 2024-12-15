package com.example.sneakersshop.Fragments.Cart

import com.example.sneakersshop.Model.Entity.Cart

data class CartState(
    var all_count: Int,
    var sum_money: Int,
    var list: List<Cart>
)

