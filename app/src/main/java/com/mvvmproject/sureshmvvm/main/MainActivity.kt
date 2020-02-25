package com.mvvmproject.sureshmvvm

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import com.mvvmproject.sureshmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mDataBinding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.data.observe(this, Observer {
            mDataBinding.tvDataView.text = it.toString()
        })
    }
}
