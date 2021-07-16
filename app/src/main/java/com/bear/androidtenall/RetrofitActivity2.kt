package com.bear.androidtenall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bear.androidtenall.module.GitHubService
import com.bear.androidtenall.module.Repo
import com.bear.androidtenall.module.UserDatabase
import com.google.gson.Gson
import io.reactivex.Scheduler
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class RetrofitActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit2)
        val dao=UserDatabase.getInstance(this).userDao()
        val retrofit=Retrofit
            .Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        val service=retrofit.create(GitHubService::class.java)
        //使用rxjava的寫法
//        service.listRepos("Jintin")
//            .subscribeOn(Schedulers.io())
//            .observeOn(Schedulers.io())
//            .subscribe(object:SingleObserver<Response<List<Repo>>>{
//                override fun onSubscribe(d: Disposable) {
//                    println("####.onSubscribe="+Thread.currentThread())
//                }
//
//                override fun onSuccess(t: Response<List<Repo>>) {
//                    var cnt=0
//                    dao.truncateUser()
//                    t.body()?.forEach {
//                        Log.d("####","第${cnt}圈")
//                        val user=it.owner;
//                        user.id=++cnt
//                        dao.insert(user)
//                    }
//
//                    dao.findUser().forEach {
//                        Log.d("####","查詢="+it.userName+",id=${it.id},adresss=${it.address}")
//                    }
//                }
//
//                override fun onError(e: Throwable) {
//
//                }
//
//            })
    //不是使用rxjava的情況
//        service.listRepos("Jintin").enqueue(object:Callback<List<Repo>>{
//            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
//                Log.d("####","response=${response}")
//                if(response.isSuccessful){
//                    Thread(){
//                        var cnt=0
//                        dao.truncateUser()
//                        response.body()?.forEach {
//                            Log.d("####","第${cnt}圈")
//                            val user=it.owner;
//                            user.id=++cnt
//                            dao.insert(user)
//                        }
//
//                        dao.findUser().forEach {
//                            Log.d("####","查詢="+it.userName+",id=${it.id},adresss=${it.address}")
//                        }
//                    }.start()
//
//                }else{
//
//                }
//            }
//
//            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//        })
    }
}