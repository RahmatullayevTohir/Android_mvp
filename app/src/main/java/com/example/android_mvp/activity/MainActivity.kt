package com.example.android_mvp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_advanced_kotlin.activity.model.Post
import com.example.android_mvc.adapter.PostAdapter
import com.example.android_mvc.network.RetrofitHttp
import com.example.android_mvc.utils.Utils
import com.example.android_mvp.R
import com.example.android_mvp.presenter.MainPresenter
import com.example.android_mvp.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),MainView {
    private lateinit var recyclerView: RecyclerView
    lateinit var mainPresenter:MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        mainPresenter = MainPresenter(this)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this, 1))
        mainPresenter.apiPostList()
    }

    fun refreshAdapter(posters: ArrayList<Post>) {
        val adapter = PostAdapter(this, posters)
        recyclerView.setAdapter(adapter)
    }


    override fun onPostListSuccess(posts: ArrayList<Post>) {
        refreshAdapter(posts!!)
    }

    override fun onPostListFailure(error: String) {
        TODO("Not yet implemented")
    }

    override fun onPostDeleteSuccess(post: Post?) {
        mainPresenter.apiPostList()
    }

    override fun onPostDeleteFailure(error: String) {
        TODO("Not yet implemented")
    }
}