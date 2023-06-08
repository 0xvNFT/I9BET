package com.i9betstoryphat.i9bet.ui.love

import android.view.View
import com.i9betstoryphat.i9bet.BaseActivity
import com.i9betstoryphat.i9bet.R
import com.i9betstoryphat.i9bet.databinding.FragmentDashboardBinding
import com.i9betstoryphat.i9bet.ui.adapter.ContentDetailAdapter
import com.i9betstoryphat.i9bet.utils.AppCache

class BookActivity : BaseActivity<FragmentDashboardBinding>() {
    override fun getViewBinding() = FragmentDashboardBinding.inflate(layoutInflater)

    private var adapter = ContentDetailAdapter()

    override fun initView() {
        super.initView()
        binding.rclMain.adapter = adapter
        adapter.clear()
        adapter.addAll(AppCache.getListContentDetail())
        binding.layoutHeader.imageBack.visibility = View.VISIBLE
        binding.layoutHeader.textHeader.setText("YÊU THÍCH")

        binding.textNovel.setOnClickListener {
            selectNovel(true)
        }

        binding.textComic.setOnClickListener {
            selectNovel(false)
        }
        binding.layoutHeader.imageBack.setOnClickListener {
            finish()
        }

        selectNovel(true)
    }

    private fun selectNovel(check: Boolean) {
        if (check) {
            binding.viewNovel.setBackgroundResource(R.color.color_text_more)
            binding.textNovel.setTextColor(resources.getColor(R.color.color_text_more))
            binding.textComic.setTextColor(resources.getColor(R.color.white))

            binding.viewComic.setBackgroundResource(R.color.white)

        } else {
            binding.viewNovel.setBackgroundResource(R.color.white)
            binding.viewComic.setBackgroundResource(R.color.color_text_more)
            binding.textNovel.setTextColor(resources.getColor(R.color.white))
            binding.textComic.setTextColor(resources.getColor(R.color.color_text_more))
        }
    }
}