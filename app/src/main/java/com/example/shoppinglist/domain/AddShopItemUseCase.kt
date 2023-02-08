package com.example.shoppinglist.domain

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopItem(shopItem: ShopingItem) {
        shopListRepository.addShopItem(shopItem)
    }
}