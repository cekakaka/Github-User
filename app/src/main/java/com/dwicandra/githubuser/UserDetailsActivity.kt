package com.dwicandra.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.dwicandra.githubuser.Model.User

class UserDetailsActivity : AppCompatActivity() {
    lateinit var ivAvatar: ImageView
    lateinit var tvName: TextView
    lateinit var tvUsername: TextView
    lateinit var tvLocations: TextView
    lateinit var tvCompany: TextView
    lateinit var tvRepositories: TextView
    lateinit var tvFollowers: TextView
    lateinit var tvFollowing: TextView

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        ivAvatar = findViewById(R.id.iv_avatar_receiver)
        tvName = findViewById(R.id.tv_name_receiver)
        tvUsername = findViewById(R.id.tv_username_receiver)
        tvLocations = findViewById(R.id.tv_locations_receiver)
        tvCompany = findViewById(R.id.tv_company_receiver)
        tvRepositories = findViewById(R.id.tv_repositories)
        tvFollowers = findViewById(R.id.tv_followers)
        tvFollowing = findViewById(R.id.tv_following)

        getBundle()
    }

    private fun getBundle() {
        val users = intent.getParcelableExtra<User>(EXTRA_USER) as User
        Glide.with(this)
            .load(users.avatar)
            .circleCrop()
            .error(R.mipmap.ic_launcher)
            .into(ivAvatar)
        tvName.text = users.name
        tvUsername.text = users.userName
        tvLocations.text = users.location
        tvCompany.text = users.company
        tvRepositories.text = users.repositories
        tvFollowers.text = users.followers
        tvFollowing.text = users.following
    }

}