package com.example.shoppinglist.domain

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList(): List<ShopingItem> {
        return shopListRepository.getShopList()
    }
}