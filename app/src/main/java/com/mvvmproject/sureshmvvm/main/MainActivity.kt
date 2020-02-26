package com.mvvmproject.sureshmvvm.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mvvmproject.sureshmvvm.R
import com.mvvmproject.sureshmvvm.adapter.ListItemsAdapter
import com.mvvmproject.sureshmvvm.common.Constants
import com.mvvmproject.sureshmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mDataBinding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(
                this,
                R.layout.activity_main
            )
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.data.observe(this, Observer {
            mDataBinding.adapter = ListItemsAdapter(it)
        })

        Constants.pie
    }
}
