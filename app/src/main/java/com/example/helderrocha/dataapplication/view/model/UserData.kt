package com.example.helderrocha.dataapplication.view.model

import com.google.gson.annotations.SerializedName

data class UserData (
        @SerializedName("data") val data: List<User>
)
