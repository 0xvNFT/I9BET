package com.i9betstoryphat.i9bet.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import com.i9betstoryphat.i9bet.base.BaseMainAdapter
import com.i9betstoryphat.i9bet.base.BaseRecyclerViewViewHolder
import com.i9betstoryphat.i9bet.data.Content
import com.i9betstoryphat.i9bet.databinding.ItemDetailContentBinding

class ContentDetailAdapter : BaseMainAdapter<Content>() {

    var click:((Content) -> Unit)? = null
    override fun onCreateHolder(view: ViewGroup): BaseRecyclerViewViewHolder<Content> {
        return Item(ItemDetailContentBinding.inflate(LayoutInflater.from(view.context), view, false)).apply {
            itemView.setOnClickListener {
                val item = mList[adapterPosition]
                click?.invoke(item)
            }
        }
    }

    class Item(val binding: ItemDetailContentBinding) :
        BaseRecyclerViewViewHolder<Content>(binding.root) {

        override fun bind(item: Content) {
            item.path?.let { binding.imageMain.setImageResource(it) }
            binding.textTitle.text = item.title
            binding.textContent.text = item.detail
            binding.textCountView.text = item.viewer.toString() + "k lượt xem"
        }
    }


}