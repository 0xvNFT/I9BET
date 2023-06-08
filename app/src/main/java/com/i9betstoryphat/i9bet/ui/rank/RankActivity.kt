package com.i9betstoryphat.i9bet.ui.rank

import com.i9betstoryphat.i9bet.BaseActivity
import com.i9betstoryphat.i9bet.R
import com.i9betstoryphat.i9bet.databinding.ActivityRankBinding
import com.i9betstoryphat.i9bet.ui.adapter.ContentDetailAdapter
import com.i9betstoryphat.i9bet.utils.AppCache
import com.i9betstoryphat.i9bet.utils.AppUtils

class RankActivity : BaseActivity<ActivityRankBinding>() {

    private var adapter = ContentDetailAdapter()

    private var selectNovel = true
    override fun getViewBinding() = ActivityRankBinding.inflate(layoutInflater)


    override fun initView() {
        super.initView()
        binding.rclMain.adapter = adapter
        adapter.clear()
        adapter.addAll(AppCache.getListContentDetail())
    }

    override fun initData() {
        super.initData()
        binding.layoutHeader.imageBack.setOnClickListener {
            finish()
        }

        binding.layoutHeader.textHeader.text = "Xếp hạng"


        binding.textNovel.setOnClickListener {
            selectNovel(true)
        }

        binding.textComic.setOnClickListener {
            selectNovel(false)
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