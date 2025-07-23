package com.testapp.activities.Login

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.testapp.activities.repostiory.RetrofitClient
import com.testapp.activities.repostiory.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginVM:ViewModel() {

    lateinit var act: LoginAct

    var logindata = MutableLiveData<loginDataClass>()
    var liveLoginData:LiveData<loginDataClass> = logindata

    fun init(activity:LoginAct){
        act = activity
    }

    fun apiLogin(){

        if (valid()){

            hitApi()
        }
    }

    fun hitApi(){


        val apiInterface =  RetrofitClient.apiService.login("251"+act.binding.edPhnNum.text.toString(),
            act.binding.edPass.text.toString(),"dfskljdfil","1")

        apiInterface.enqueue(object : Callback<loginDataClass> {
            override fun onResponse(
                call: Call<loginDataClass>,
                response: Response<loginDataClass>
            ) {

                if (response.body()?.status == "1"){

                    logindata.value = response.body()

                }else{
                    Toast.makeText(act,"Error",Toast.LENGTH_LONG).show()

                }

            }

            override fun onFailure(call: Call<loginDataClass>, t: Throwable) {
               Toast.makeText(act,"Failed",Toast.LENGTH_LONG).show()
            }

        })
//
//
    }

    fun valid():Boolean{

        var value = false

        if (act.binding.edPhnNum.text.isNullOrEmpty()){
            Toast.makeText(act,"Enter phone number",Toast.LENGTH_LONG).show()
        }
        else if (act.binding.edPass.text.isNullOrEmpty()){
            Toast.makeText(act,"Enter password",Toast.LENGTH_LONG).show()

        }
        else{
            value = true
        }

        return value

    }

}