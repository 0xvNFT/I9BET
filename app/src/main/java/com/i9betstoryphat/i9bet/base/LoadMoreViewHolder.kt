package com.i9betstoryphat.i9bet.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.i9betstoryphat.i9bet.R

class LoadMoreViewHolder<T>(view: View) : BaseRecyclerViewViewHolder<T>(view) {

    override fun bind(item: T) {}

    companion object {
        fun <M>create(parent: ViewGroup): LoadMoreViewHolder<M> {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.x_item_loading_more_linear, parent, false)
            return LoadMoreViewHolder(itemView)
        }
    }

}
