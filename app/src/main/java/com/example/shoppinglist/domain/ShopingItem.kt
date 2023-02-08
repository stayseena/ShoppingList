package com.example.shoppinglist.domain

data class ShopingItem(
    val name: String,
    val count: Int,
    val enabled: Boolean,
    var id: Int = -1
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}
