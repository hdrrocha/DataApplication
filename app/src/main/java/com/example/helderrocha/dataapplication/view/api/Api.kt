package com.example.helderrocha.dataapplication.view.api
import android.service.autofill.UserData
import io.reactivex.Single
import retrofit2.http.GET

interface Api {
    companion object {
        const val URL = "https://s3-sa-east-1.amazonaws.com/"
    }
    @GET("pontotel-docs/data.json" )
    fun requestUsers(): Single<UserData>

}