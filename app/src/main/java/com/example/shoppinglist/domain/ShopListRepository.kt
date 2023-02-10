package com.example.shoppinglist.domain

interface ShopListRepository {
    fun addShopItem(shopItem: ShopingItem)
    fun deleteShopItem(shopItem: ShopingItem)
    fun editShopItem(shopItem: ShopingItem)
    fun getShopItem(shopItemId : Int): ShopingItem
    fun getShopList(): List<ShopingItem>
}