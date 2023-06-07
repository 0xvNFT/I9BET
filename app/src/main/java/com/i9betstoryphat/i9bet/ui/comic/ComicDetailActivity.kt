package com.i9betstoryphat.i9bet.ui.comic

import android.content.Intent
import com.i9betstoryphat.i9bet.BaseActivity
import com.i9betstoryphat.i9bet.databinding.ActivityDetailComicBinding
import com.i9betstoryphat.i9bet.ui.home.HomeFragment
import com.i9betstoryphat.i9bet.ui.read.ReadContentActivity
import com.i9betstoryphat.i9bet.utils.AppCache
import com.i9betstoryphat.i9bet.utils.AppUtils

class ComicDetailActivity : BaseActivity<ActivityDetailComicBinding>() {

    private lateinit var adapter: ComicAdapter
    override fun getViewBinding() = ActivityDetailComicBinding.inflate(layoutInflater)


    override fun initView() {
        super.initView()
        var item = HomeFragment.contentCurrent
        binding.titleHeader.text = item.title.toString()
        binding.titleContent.text = item.detail.toString()
        item.path?.let { binding.imageMain.setImageResource(it) }
        adapter = ComicAdapter()

        binding.rclMain.adapter = adapter
        adapter.clear()
        adapter.addAll(AppCache.getListContent())

        binding.btnOk.setOnClickListener {
            startActivity(Intent(this, ReadContentActivity::class.java))
        }

        binding.imageBack.setOnClickListener {
            finish()
        }
    }

}