package com.testapp.activities.repostiory

import com.testapp.activities.Login.loginDataClass
import com.testapp.activities.listAct.Post
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {


    @FormUrlEncoded
    @POST("api/customer/customer_login")
    fun login(
        @Field("phone_number") phone_number: String,
        @Field("password") password: String,
        @Field("fcm_token") fcm_token: String,
        @Field("device_type") device_type: String
    ):Call<loginDataClass>

    @FormUrlEncoded
    @POST("api/customer/customer_login")
    suspend fun login2(
        @Field("phone") phone: String,
        @Field("password") password: String,
        @Field("fcm_token") fcmToken: String,
        @Field("device_type") deviceType: String
    ): Response<loginDataClass>

    @GET("posts")
    fun postList():Call<List<Post>>

}