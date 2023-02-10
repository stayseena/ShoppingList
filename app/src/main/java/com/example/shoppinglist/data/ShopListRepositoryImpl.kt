package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.domain.ShopListRepository
import com.example.shoppinglist.domain.ShopingItem

object ShopListRepositoryImpl: ShopListRepository {

    private val shopListLD = MutableLiveData<List<ShopingItem>>()
    private val shopList = mutableListOf<ShopingItem>()
    private var autoIncrementId = 0
    init {
        for (i in 0 until 10) {
            val item = ShopingItem("Name $1", i, true)
            addShopItem(item)
        }
    }

    override fun editShopItem(shopItem: ShopingItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopingItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun addShopItem(shopItem: ShopingItem) {
        if (shopItem.id == ShopingItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun getShopItem(shopItemId: Int): ShopingItem {
       return shopList.find {
           it.id == shopItemId
       } ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun getShopList(): LiveData<List<ShopingItem>> {
        return shopListLD
    }

    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}