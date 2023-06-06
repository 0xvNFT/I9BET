package com.i9betstoryphat.i9bet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding : T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  getViewBinding()
        setContentView(binding.root)

        initView()
        initData()
    }

    abstract fun getViewBinding(): T

    protected open fun initView() {

    }

    protected open fun initData() {

    }
}