package com.i9betstoryphat.i9bet.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseMainAdapter<T> :
    RecyclerView.Adapter<BaseRecyclerViewViewHolder<T>>() {
    protected open var mList = mutableListOf<T>()
    private val VIEW_TYPE_ITEM = 1
    private val VIEW_TYPE_LOAD_MORE = 2
    private var isLoadMoreOrRefresh = false

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewViewHolder<T> {
        return if (viewType == VIEW_TYPE_LOAD_MORE) {
            LoadMoreViewHolder.create(parent)
        } else {
            onCreateHolder(parent)
        }
    }

    open fun onBindView(layoutID: Int, parent: ViewGroup) : View {
        return LayoutInflater.from(parent.context).inflate(layoutID,
            parent, false)
    }

    protected abstract fun onCreateHolder(view: ViewGroup): BaseRecyclerViewViewHolder<T>

    open fun onViewHolderCreated(holder: BaseRecyclerViewViewHolder<T>) {}

    open fun setupActions(itemView: View, item: T, position: Int) {}

    override fun onBindViewHolder(holder: BaseRecyclerViewViewHolder<T>, position: Int) {
        if (holder !is LoadMoreViewHolder) {
            holder.bind(mList[position])
            onViewHolderCreated(holder)
            setupActions(holder.itemView, mList[position], position)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    open fun addAll(list: List<T>?) {
        val oldSize = itemCount
        isLoadMoreOrRefresh = false
        if (list != null && list.isNotEmpty()) {
            mList.addAll(list)
            notifyItemRangeInserted(oldSize, list.size)
        }
    }

    open fun clear() {
        isLoadMoreOrRefresh = false
        mList.clear()
        notifyDataSetChanged()
    }

    open fun add(e: T?) {
        isLoadMoreOrRefresh = false
        mList.add(e!!)
        notifyDataSetChanged()
    }

    open fun update(position: Int, e:T?) {
        isLoadMoreOrRefresh = false
        mList[position] = e!!
        notifyItemChanged(position)
    }

    open fun remove(position: Int) {
        isLoadMoreOrRefresh = false
        mList.removeAt(position)
        notifyItemRemoved(position)
    }

    open fun addLoadingFooter(e: T?) {
        isLoadMoreOrRefresh = true
        mList.add(e!!)
        notifyItemInserted(mList.size - 1)
    }

    open fun getItem(position: Int): T? {
        return mList[position]
    }

    open fun getListAllData() : List<T>? {
        return mList
    }

    fun isPositionFooter(position: Int): Boolean {
        return position == itemCount - 1 && isLoadMoreOrRefresh
    }

    open fun removeLoadingFooter() {
        isLoadMoreOrRefresh = false
        val position = mList.size - 1
        if (position == -1) return
        val o: T = getItem(position)!!
        if (o != null) {
            mList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == mList.size - 1 &&
            isLoadMoreOrRefresh
        ) VIEW_TYPE_LOAD_MORE else VIEW_TYPE_ITEM
    }
}