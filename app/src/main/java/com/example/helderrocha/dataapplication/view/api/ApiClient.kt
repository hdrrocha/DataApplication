package com.example.helderrocha.dataapplication.view.api
import android.service.autofill.UserData
import io.reactivex.Single
import javax.inject.Inject

class ApiClient @Inject constructor(private val gitApi: GitApi) {
    fun requestUsers(): Single<UserData> {
        return gitApi.requestUsers()
    }
}