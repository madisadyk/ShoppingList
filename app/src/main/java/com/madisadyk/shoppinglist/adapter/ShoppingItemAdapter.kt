package com.madisadyk.shoppinglist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madisadyk.shoppinglist.R
import com.madisadyk.shoppinglist.data.db.entities.ShoppingItem
import com.madisadyk.shoppinglist.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewmodel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {

        val curShoppingItem = items[position]

        holder.itemView.tvName.text = curShoppingItem.name
        holder.itemView.tvAmount.text = "${curShoppingItem.amount}"

        holder.itemView.ivDelete.setOnClickListener {
            viewmodel.delete(curShoppingItem)
        }

        holder.itemView.ivMinus.setOnClickListener {
            if (curShoppingItem.amount == 1) {
                viewmodel.delete(curShoppingItem)
            } else if (curShoppingItem.amount > 0) {
                curShoppingItem.amount--
                viewmodel.upsert(curShoppingItem)
            }
        }

        holder.itemView.ivPlus.setOnClickListener {
            if (curShoppingItem.amount == 1) {
                viewmodel.delete(curShoppingItem)
            } else if (curShoppingItem.amount > 0) {
                curShoppingItem.amount++
                viewmodel.upsert(curShoppingItem)
            }
        }
    }

    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}