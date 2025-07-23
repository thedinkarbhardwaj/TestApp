package com.testapp.activities.repostiory

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {

//    private const val BASE_URL = "https://admin.vipi.co.ke" // Change to your API
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/" // Change to your API

    val apiService by lazy {

        val interceptor = HttpLoggingInterceptor()

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(100, TimeUnit.SECONDS)
            .writeTimeout(2.toLong() * 60, TimeUnit.SECONDS)
            .readTimeout(2.toLong() * 60, TimeUnit.SECONDS)
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ApiService::class.java)
    }

}