package com.example.shoppinglist.presentation

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.ShopListRepositoryImpl
import com.example.shoppinglist.domain.*

class MainViewModel: ViewModel() {
    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun deleteShpItem(shopingItem: ShopingItem) {
        deleteShopItemUseCase.deleteShopItem(shopingItem)
    }

    fun changeEnableState(shopingItem: ShopingItem) {
        val newItem = shopingItem.copy(enabled = shopingItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}
