package com.example.helderrocha.dataapplication.view.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.helderrocha.dataapplication.R
import dagger.android.AndroidInjection

class ListDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_user_data_activity)
    }
}
