package com.i9betstoryphat.i9bet.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @param T is a data class
 */
abstract class BaseRecyclerViewViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(item: T)

}
