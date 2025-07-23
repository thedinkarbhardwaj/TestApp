package com.testapp.activities.repostiory

import android.widget.Toast
import com.testapp.activities.Login.LoginAct
import com.testapp.activities.Login.loginDataClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    suspend fun loginUser(
        phone: String,
        password: String,
        fcmToken: String,
        deviceType: String
    ): Result<loginDataClass> {
        return try {
            val response = RetrofitClient.apiService
                .login2(phone, password, fcmToken, deviceType)

            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Throwable("Login failed: ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
