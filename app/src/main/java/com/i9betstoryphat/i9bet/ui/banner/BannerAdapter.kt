package com.i9betstoryphat.i9bet.ui.banner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.i9betstoryphat.i9bet.R
import com.i9betstoryphat.i9bet.data.Banner
import com.i9betstoryphat.i9bet.databinding.LayoutBannerItemBinding

class BannerAdapter(private val list: List<Banner>, val context: Context) : PagerAdapter() {
    override fun getCount() = list.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val binding = LayoutBannerItemBinding.inflate(inflater, container, false)
        val item = list[position]
        item.path?.let { binding.imageMain.setImageResource(it) }
        container.addView(
            binding.root,
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        return binding.root

    }


}