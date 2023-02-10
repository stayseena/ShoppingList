package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addShopItem(shopItem: ShopingItem)
    fun deleteShopItem(shopItem: ShopingItem)
    fun editShopItem(shopItem: ShopingItem)
    fun getShopItem(shopItemId : Int): ShopingItem
    fun getShopList(): LiveData<List<ShopingItem>>
}