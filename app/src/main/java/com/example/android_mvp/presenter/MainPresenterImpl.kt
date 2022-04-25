package com.example.android_mvp.presenter

import com.example.android_advanced_kotlin.activity.model.Post
import retrofit2.http.POST

interface MainPresenterImpl {
    fun apiPostList()
    fun apiPostDelete(post: Post)
}