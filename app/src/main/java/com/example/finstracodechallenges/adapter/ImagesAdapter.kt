package com.example.finstracodechallenges.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.finstracodechallenges.R
import com.example.finstracodechallenges.model.ImageResponse

class ImagesAdapter(private val context: Context, private val images: List<ImageResponse>): RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = images[position]
        val defaultOptions = RequestOptions().error(R.drawable.ic_launcher_background)
        Glide.with(context).setDefaultRequestOptions(defaultOptions)
            .load(image.urls.regular)
            .centerCrop()
            .into(holder.imageView)
        holder.descTextView.text = image.alt_description ?: "No Description"
        holder.userTextView.text = image.user.name
        holder.likesTextView.text = image.likes.toString()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.image_iv)
        var descTextView: TextView = itemView.findViewById(R.id.image_desc_tv)
        var userTextView: TextView = itemView.findViewById(R.id.user_name_tv)
        var likesTextView: TextView = itemView.findViewById(R.id.like_tv)
    }
}