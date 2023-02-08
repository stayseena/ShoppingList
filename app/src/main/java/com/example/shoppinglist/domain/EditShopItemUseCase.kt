package com.example.shoppinglist.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopItem(shopItem: ShopingItem) {
        shopListRepository.editShopItem(shopItem)
    }
}