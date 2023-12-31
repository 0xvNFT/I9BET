package com.i9betstoryphat.i9bet.ui.content

import android.content.Intent
import com.i9betstoryphat.i9bet.BaseActivity
import com.i9betstoryphat.i9bet.data.Content
import com.i9betstoryphat.i9bet.databinding.ActivityDetailContentBinding
import com.i9betstoryphat.i9bet.ui.adapter.ContentDetailAdapter
import com.i9betstoryphat.i9bet.ui.home.HomeFragment
import com.i9betstoryphat.i9bet.ui.read.ReadContentActivity
import com.i9betstoryphat.i9bet.utils.AppCache

class ContentDetailActivity : BaseActivity<ActivityDetailContentBinding>() {

    private lateinit var adapter: ContentDetailAdapter

    private var isClick = false
    private var contentDetail = Content()
    override fun getViewBinding() = ActivityDetailContentBinding.inflate(layoutInflater)

    override fun initView() {
        super.initView()
        var item = HomeFragment.contentCurrent
        binding.titleHeader.text = item.title.toString()
        binding.titleContent.text = item.detail.toString()
        item.path?.let { binding.imageMain.setImageResource(it) }
        adapter = ContentDetailAdapter()
        binding.rclMain.adapter = adapter

        adapter.clear()
        adapter.addAll(AppCache.getListContentDetail())
        binding.btnRead.setOnClickListener {
            if (isClick) {
                HomeFragment.contentCurrent = contentDetail
            }
            startActivity(Intent(this, ReadContentActivity::class.java))
        }

        binding.layoutHeader.imageBack.setOnClickListener { finish() }

        adapter.click = {
            contentDetail = it
            isClick = true
            binding.titleHeader.text = it.title
            binding.titleContent.text = it.detail
            it.path?.let { it1 -> binding.imageMain.setImageResource(it1) }
        }
    }

}