package com.dwicandra.githubuser.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var avatar: String,
    var name: String,
    var userName: String,
    var location: String,
    var company: String,
    var repositories: String,
    var followers: String,
    var following: String,
) : Parcelable
