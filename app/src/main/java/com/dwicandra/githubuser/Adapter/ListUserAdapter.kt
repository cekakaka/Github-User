package com.dwicandra.githubuser.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dwicandra.githubuser.Model.User
import com.dwicandra.githubuser.R
import com.dwicandra.githubuser.UserDetailsActivity
import com.dwicandra.githubuser.databinding.RowLayoutItemUserBinding

class ListUserAdapter(private val dataUser: ArrayList<User>) :
    RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            RowLayoutItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (avatar, name, username) = dataUser[position]
        Glide.with(holder.itemView.context)
            .load(avatar)
            .circleCrop()
            .error(R.mipmap.ic_launcher)
            .into(holder.binding.ivAvatar)
        holder.binding.tvName.text = name
        holder.binding.tvUsername.text = username
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, UserDetailsActivity::class.java)
            intent.putExtra(UserDetailsActivity.EXTRA_USER, dataUser[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataUser.size
    }

    class ListViewHolder(val binding: RowLayoutItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

}