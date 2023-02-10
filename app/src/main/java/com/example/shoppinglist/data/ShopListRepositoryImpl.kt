package com.example.shoppinglist.data

import com.example.shoppinglist.domain.ShopListRepository
import com.example.shoppinglist.domain.ShopingItem

object ShopListRepositoryImpl: ShopListRepository {

    private val shopList = mutableListOf<ShopingItem>()
    private var autoIncrementId = 0

    override fun editShopItem(shopItem: ShopingItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopingItem) {
        shopList.remove(shopItem)
    }

    override fun addShopItem(shopItem: ShopingItem) {
        if (shopItem.id == ShopingItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopingItem {
       return shopList.find {
           it.id == shopItemId
       } ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun getShopList(): List<ShopingItem> {
        return shopList.toList()
    }
}