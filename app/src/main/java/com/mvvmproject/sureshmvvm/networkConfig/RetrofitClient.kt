package com.mvvmproject.sureshmvvm

import android.os.Build
import android.preference.PreferenceManager
import android.util.Log
import androidx.annotation.RequiresApi
import cchcc.learn.amu.ApiService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private var instance: ApiService? = null
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun getInstance(): ApiService? {
        if (instance == null) {
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build()
            instance = retrofit.create(ApiService::class.java)
        }
        return instance
    }

    //.cache(new Cache(MvpApplication.getInstance().getCacheDir(), 10 * 1024 * 1024)) // 10 MB
    val httpClient: OkHttpClient
        get() {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient()
                    .newBuilder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .addNetworkInterceptor(AddHeaderInterceptor())
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .addInterceptor(interceptor)
                    .build()
        }

    class AddHeaderInterceptor : Interceptor {
        @RequiresApi(Build.VERSION_CODES.KITKAT)
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val builder = chain.request().newBuilder()
            builder.addHeader("X-Requested-With", "XMLHttpRequest")
            val token = Objects.requireNonNull(
                    "AccessToken",
                    ""
            )
            builder.addHeader("Authorization", token + token)
            Log.d("TTT access_token", token)
            return chain.proceed(builder.build())
        }
    }

}