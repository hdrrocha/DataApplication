package com.example.helderrocha.dataapplication.view.api
import com.example.helderrocha.dataapplication.view.model.UsersData
import io.reactivex.Single
import retrofit2.http.GET

interface Api {
    companion object {
        const val URL = "https://s3-sa-east-1.amazonaws.com/"
    }
    @GET("pontotel-docs/data.json" )
    fun requestUsers(): Single<UsersData>

}