package com.example.androidbaseapplication.data.remote

import android.content.Context
import com.example.androidbaseapplication.utils.Constants
import com.example.androidbaseapplication.utils.ContextModule
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit


object RetrofitBuilder {

    private const val BASE_URL = "https://5e510330f2c0d300147c034c.mockapi.io/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOhttpClient())
            .build() //Doesn't require the adapter
    }

    private fun getOhttpClient(): OkHttpClient {

        val client = OkHttpClient.Builder()
            .addInterceptor(ChuckInterceptor(ContextModule.context))
            .addNetworkInterceptor(NetworkInterceptor())
            .connectTimeout(Constants.TIMEOUT,TimeUnit.MILLISECONDS)
            .readTimeout(Constants.TIMEOUT,TimeUnit.MILLISECONDS)
            .writeTimeout(Constants.TIMEOUT,TimeUnit.MILLISECONDS)
            .build()

        return client

    }

    private class NetworkInterceptor() : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {

            val primary: Request = chain.request()
            val builder = primary.newBuilder()

            builder.addHeader("parameter", "value").build()

            val request = builder
                .method(primary.method, primary.body)
                .build()
            return chain.proceed(request)

        }

    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}