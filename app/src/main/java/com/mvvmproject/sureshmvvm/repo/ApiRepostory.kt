package com.mvvmproject.sureshmvvm

import cchcc.learn.amu.ApiLisener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ApiRepostory {

    fun dataFromApi(apiLisener: ApiLisener):Disposable?{
        return RetrofitClient.getInstance()?.getApi()?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeOn(Schedulers.io())
                ?.subscribe({
                    apiLisener.onSuccess(it)
                }, {
                    apiLisener.onFailure(it)
                })
    }

    companion object {
        private var appRepository: ApiRepostory? = null

        fun instance(): ApiRepostory {
            if (appRepository == null) synchronized(ApiRepostory) {
                appRepository = ApiRepostory()
            }
            return appRepository!!
        }
    }
}