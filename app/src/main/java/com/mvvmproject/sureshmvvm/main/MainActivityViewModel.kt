package com.mvvmproject.sureshmvvm.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cchcc.learn.amu.ApiLisener
import com.google.gson.JsonArray
import com.mvvmproject.sureshmvvm.repo.ApiRepostory

class MainActivityViewModel : ViewModel() {

    var data = MutableLiveData<JsonArray>()
    private var mRepostory =
        ApiRepostory.instance()

    init {
        mRepostory.dataFromApi(object : ApiLisener {
            override fun onSuccess(successData: Any) {
                data.value = successData as JsonArray
            }

            override fun onFailure(error: Throwable) {
                Log.d("Error", error.toString())
            }

        })
    }

}