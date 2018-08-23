package com.example.helderrocha.dataapplication.view.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.helderrocha.dataapplication.R
import com.example.helderrocha.dataapplication.view.view.adapters.UserAdapter
import com.example.helderrocha.dataapplication.view.model.User
import com.example.helderrocha.dataapplication.view.view_model.UserDataViewModel
import com.example.helderrocha.dataapplication.view.view_model.ViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.list_user_data_activity.*
import java.util.*
import javax.inject.Inject

class ListDataActivity : AppCompatActivity() {

    @Inject
    lateinit var usersVMFactory: ViewModelFactory<UserDataViewModel>

    private val usersViewModel by lazy {
        ViewModelProviders.of(this, usersVMFactory)[UserDataViewModel::class.java]
    }

    protected val usersObserver = Observer<ArrayList<User>>(::onItemsFetched)
    private lateinit var adapter: UserAdapter
    var layoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_user_data_activity)

        recyclerViewUsers.layoutManager = layoutManager
        recyclerViewUsers.setHasFixedSize(true)

        usersViewModel.data.observe(this, usersObserver)
        usersViewModel.getUsers()
    }

    private fun onItemsFetched(users: List<User>?) {
        if (users != null) {
            adapter = UserAdapter(users, { item: User -> partItemClicked(item) })
            recyclerViewUsers.adapter = adapter
            progressBar.visibility = View.GONE
        } else {
            Toast.makeText(this, "Não existem usuários", Toast.LENGTH_SHORT).show()
        }

    }

    private fun partItemClicked(item : User) {
        val intent = Intent(this,GifActivity::class.java)
        var number = Random().nextInt(2) +1
        intent.putExtra("number", number.toString())
        startActivity(intent)
    }

}
