package com.dwicandra.githubuser

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dwicandra.githubuser.Adapter.ListUserAdapter
import com.dwicandra.githubuser.Model.User
import com.dwicandra.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var dataUser = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rvUserItem.setHasFixedSize(true)

        dataUser.addAll(listUser)
        showRecycleView()

    }

    private val listUser: ArrayList<User>
        get() {
            val dataPhoto = resources.getStringArray(R.array.avatar)
            val dataName = resources.getStringArray(R.array.name)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataLocations = resources.getStringArray(R.array.location)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataRepositories = resources.getStringArray(R.array.repository)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val listUser = ArrayList<User>()
            for (i in dataName.indices) {
                val users = User(
                    dataPhoto[i],
                    dataName[i],
                    dataUsername[i],
                    dataLocations[i],
                    dataCompany[i],
                    dataRepositories[i],
                    dataFollowers[i],
                    dataFollowing[i]
                )
                listUser.add(users)
            }
            return listUser
        }

    private fun showRecycleView() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvUserItem.layoutManager = GridLayoutManager(this, 2)
        } else {
            binding.rvUserItem.layoutManager = LinearLayoutManager(this)
        }
        val listAdapter = ListUserAdapter(dataUser)
        binding.rvUserItem.adapter = listAdapter
    }


}