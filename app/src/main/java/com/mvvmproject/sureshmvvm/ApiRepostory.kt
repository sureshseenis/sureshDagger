package com.mvvmproject.sureshmvvm

import cchcc.learn.amu.ApiLisener
import cchcc.learn.amu.ApiService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TestRepostory {
    

    fun testApiAnother(apiLisener: ApiLisener):Disposable?{
        return RetrofitClient.getInstance()?.getApi()?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeOn(Schedulers.io())
                ?.subscribe({
                    apiLisener.onSuccess(it)
                }, {
                    apiLisener.onFailure(it)
                })
    }

    companion object {
        private var appRepository: TestRepostory? = null

        fun instance(): TestRepostory {
            if (appRepository == null) synchronized(TestRepostory) {
                appRepository = TestRepostory()
            }
            return appRepository!!
        }
    }
}