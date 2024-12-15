package com.example.sneakersshop.Fragments.Profile

sealed interface ProfileEvent {
    data object ToCatalog : ProfileEvent
    data object ToCart : ProfileEvent
    data object ToOrders : ProfileEvent
    data object SignOut : ProfileEvent
}