package com.example.helderrocha.dataapplication.view.view_model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.helderrocha.dataapplication.view.SchedulerProvider
import com.example.helderrocha.dataapplication.view.api.ApiClient
import com.example.helderrocha.dataapplication.view.model.User
import com.example.helderrocha.dataapplication.view.model.UsersData
import javax.inject.Inject


class UserDataViewModel @Inject constructor(val api: ApiClient, private val schedulers: SchedulerProvider) : ViewModel() {

    val _data = MutableLiveData<ArrayList<User>>()
    val data: LiveData<ArrayList<User>> = _data

    fun getUsers() {
        api.requestUsers()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.mainThread())
                .subscribe({
                    _data.value = it.data
                }, {
                    Log.i("ERROR", it.message)
                })
    }
}
