package com.bear.androidtenall.module

import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubService {
    @GET("users/{user}/repos")
//    fun listRepos(@Path("user") user:String,@Query("type") type:String?=null ,@Query("sort") sort:String?=null): Single<Response<List<Repo>>>
    fun listRepos(@Path("user") user:String,@Query("type") type:String?=null ,@Query("sort") sort:String?=null): Call<List<Repo>>  //不使用rxjava 的話回傳值是
}