package com.madisadyk.shoppinglist.data.repositories

import com.madisadyk.shoppinglist.data.db.ShoppingDao
import com.madisadyk.shoppinglist.data.db.ShoppingDatabase
import com.madisadyk.shoppinglist.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(itme: ShoppingItem) = db.getShoppingDao().delete(itme)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}