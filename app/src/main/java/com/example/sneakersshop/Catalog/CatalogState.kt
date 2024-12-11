package com.example.sneakersshop.Catalog

import android.graphics.drawable.Drawable

data class CatalogState(
    val list: MutableList<Boot>
)

data class Boot(
    val name: String,
    val category: String,
    val price: Float,
    val drawable: Drawable
)