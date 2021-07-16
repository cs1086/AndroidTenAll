package com.bear.androidtenall

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bear.androidtenall.module.GitHubService
import com.bear.androidtenall.module.Repo
import io.reactivex.*
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView:TextView=findViewById(R.id.myText);
        textView.text="早安"
        textView.setOnClickListener{
            textView.text="晚安"
        }
        textView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                textView.text="午安"
                var intent= Intent(this@MainActivity,AnotherActivity::class.java)
//                var sendIntent=Intent(ACTION_SEND)
//                sendIntent.putExtra(Intent.EXTRA_TEXT,"你好嗎")
//                var shareInten=Intent.createChooser(sendIntent,null)
                startActivity(intent)
            }

        })
        //測試rxjava
//        Thread(){
//            Observable.just(1,2,3)
//                .filter{println("####.filter="+Thread.currentThread())
//                it%2==1}
//                .map{println("####.map="+Thread.currentThread())
//                (it*2).toString()}
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(object:Observer<String>{
//                override fun onSubscribe(d: Disposable) {
//                    println("####.onSubscribe="+Thread.currentThread())
//                }
//
//                override fun onNext(t: String) {
//                    println("####.onNext=${t}="+Thread.currentThread())
//
//                }
//
//                override fun onError(e: Throwable) {
//                    println("####.onError="+Thread.currentThread())
//
//                }
//
//                override fun onComplete() {
//                    println("####.onComplete="+Thread.currentThread())
//
//                }
//
//            })
//        }.start()
        val retrofit= Retrofit
            .Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        val service=retrofit.create(GitHubService::class.java)
        val observable:Observable<String> = Observable.create(object :ObservableOnSubscribe<String>{
            override fun subscribe(emitter: ObservableEmitter<String>) {
                service.listRepos("Jintin").enqueue(object: Callback<List<Repo>> {
                    override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                        Log.d("####","response=${response.body()?.size}")
                        var cnt=0
                        response.body()?.forEach {
                            val user=it.owner
                            emitter.onNext(user.userName)
                            Log.d("####","cnt=${++cnt},user=${user}")
                        }
                        emitter.onComplete()
                       // Log.d("####","response=${response.body()}")
                    }

                    override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                })
            }

        }).subscribeOn(Schedulers.newThread());
        observable.observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<String> {
                override fun onSubscribe(@NonNull d: Disposable) {}
                override fun onNext(o: String) {
                    Log.d("####","o=${o}")
                }

                override fun onError(@NonNull e: Throwable) {
                    Toast.makeText(this@MainActivity, e.toString(), Toast.LENGTH_SHORT).show()
                }

                override fun onComplete() {
                    Toast.makeText(this@MainActivity, "download OK", Toast.LENGTH_SHORT).show()
                }
            })

    }
}