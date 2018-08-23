package com.example.helderrocha.dataapplication.view.model

import com.google.gson.annotations.SerializedName

data class UsersData (
        @SerializedName("data") val data: ArrayList<User>
)
