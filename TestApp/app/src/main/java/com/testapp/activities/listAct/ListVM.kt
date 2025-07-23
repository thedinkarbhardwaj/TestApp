package com.testapp.activities.listAct

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.testapp.activities.repostiory.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var act: ListAct
var _postlist = MutableLiveData<List<Post>>()
var postList:LiveData<List<Post>> = _postlist

class ListVM:ViewModel() {

    fun init(activity: ListAct){
        act = activity

        postListApi()
    }

    private fun postListApi() {

        var apiInterface = RetrofitClient.apiService.postList()

        apiInterface.enqueue(object :Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                _postlist.value = response.body()
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
               Toast.makeText(act,"List Failed",Toast.LENGTH_SHORT).show()
            }

        })

    }
}