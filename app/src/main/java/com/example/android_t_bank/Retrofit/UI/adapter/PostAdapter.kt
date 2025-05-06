package com.example.android_t_bank.Retrofit.UI.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_t_bank.R
import com.example.android_t_bank.Retrofit.data.model.Post

class PostAdapter(private val posts: List<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView  = itemView.findViewById(R.id.postTitle)
        val userId: TextView  = itemView.findViewById(R.id.userId)
        val idPost: TextView  = itemView.findViewById(R.id.idPost)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent,false)
        return  PostViewHolder(view)
    }

    override fun getItemCount(): Int = posts.size


    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
       holder.title.text = posts[position].title
        holder.userId.text = posts[position].userId.toString()
        holder.idPost.text = posts[position].id.toString()
    }
}