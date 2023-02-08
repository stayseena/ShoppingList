package com.example.shoppinglist.domain

interface ShopListRepository {
    fun addShopItem(shopItem: ShopingItem)
    fun deleteShopItem(shopItem: ShopingItem)
    fun editShopItem(shopItem: ShopingItem)
    fun getShopItem(shopItemId : Int)
    fun getShopList(): List<ShopingItem>
}