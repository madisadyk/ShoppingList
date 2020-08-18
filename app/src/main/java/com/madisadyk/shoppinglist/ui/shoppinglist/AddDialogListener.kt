package com.madisadyk.shoppinglist.ui.shoppinglist

import com.madisadyk.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {

    fun onAddButtonClicked(item: ShoppingItem)
}