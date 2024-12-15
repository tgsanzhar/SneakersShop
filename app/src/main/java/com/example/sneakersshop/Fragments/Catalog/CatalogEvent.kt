package com.example.sneakersshop.Fragments.Catalog

import com.example.sneakersshop.Fragments.Cart.CartEvent

sealed interface CatalogEvent {
    data class onClickToBuy(val id: Int) : CatalogEvent
    data object ToCart : CatalogEvent
    data object ToProfile : CatalogEvent
}