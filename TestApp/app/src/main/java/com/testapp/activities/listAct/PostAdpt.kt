package com.testapp.activities.listAct

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testapp.databinding.CustomPostBinding

class PostAdpt(private val postList: List<Post>) : RecyclerView.Adapter<PostAdpt.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       var bindd = CustomPostBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(bindd)
    }

    override fun getItemCount(): Int {
       return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.txtBinding.text = postList.get(position).title
    }

    class ViewHolder(binding: CustomPostBinding): RecyclerView.ViewHolder(binding.root) {

        var txtBinding = binding.customTitle

    }

}
