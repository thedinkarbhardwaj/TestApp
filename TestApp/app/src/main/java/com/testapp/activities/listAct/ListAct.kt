package com.testapp.activities.listAct

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.testapp.databinding.ActivityListBinding
import com.testapp.roomDB.PostDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListAct : AppCompatActivity() {

    lateinit var binding:ActivityListBinding
    lateinit var viewModel:ListVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this@ListAct).get(ListVM::class.java)
        viewModel.init(this@ListAct)



        setUI()



    }

    private fun setUI() {

        postList.observe(this@ListAct,{

            recyclerView(it)

        })


        GlobalScope.launch {

            var dbbb= PostDatabase.getInstance(this@ListAct).postDao().getAllPosts()

            Log.d("ListOfPPost",dbbb.toString())

        }

    }

    private fun recyclerView(posts: List<Post>) {

        var lay = LinearLayoutManager(act)
        lay.orientation = LinearLayoutManager.VERTICAL

binding.recPost.layoutManager = lay
        binding.recPost.adapter = PostAdpt(this@ListAct,posts)

    }
}