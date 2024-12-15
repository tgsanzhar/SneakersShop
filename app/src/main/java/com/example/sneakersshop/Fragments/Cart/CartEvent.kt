package com.example.sneakersshop.Fragments.Cart

sealed interface CartEvent {
    data object ToCatalog : CartEvent
    data object ToProfile : CartEvent
    data class PlusCount(val id: Int) : CartEvent
    data class MinusCount(val id: Int) : CartEvent
    data object Order : CartEvent
}