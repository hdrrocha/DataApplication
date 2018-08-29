package com.example.helderrocha.dataapplication.view.api

import com.example.helderrocha.dataapplication.view.model.UsersData
import io.reactivex.Single
import javax.inject.Inject

class ApiClient @Inject constructor(private val api: Api) {
    fun requestUsers(): Single<UsersData> {
        return api.requestUsers()
    }
}