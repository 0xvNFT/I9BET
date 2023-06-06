package com.i9betstoryphat.i9bet.customview

import androidx.viewpager.widget.ViewPager

open class PagerScroll : ViewPager.OnPageChangeListener {
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        onScrolled(position, positionOffset, positionOffsetPixels)
    }
    override fun onPageSelected(position: Int) {
        onSelected(position)
    }
    override fun onPageScrollStateChanged(state: Int) {
        onStateChanged(state)
    }

    open fun onScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
    open fun onSelected(position: Int) {}
    open fun onStateChanged(state: Int) {}

}
