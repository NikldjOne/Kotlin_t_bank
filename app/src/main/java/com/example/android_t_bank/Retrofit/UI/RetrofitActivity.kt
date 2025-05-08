package com.example.android_t_bank.Retrofit.UI

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_t_bank.R
import com.example.android_t_bank.Retrofit.UI.adapter.PostAdapter
import com.example.android_t_bank.Retrofit.data.model.Post
import com.example.android_t_bank.Retrofit.data.network.ApiClient
import com.example.android_t_bank.Retrofit.data.network.ApiService
import com.example.android_t_bank.Retrofit.data.network.OperationService
import com.example.android_t_bank.Retrofit.data.network.Operations
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RetrofitActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_retrofit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView = findViewById(R.id.retrofitRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val apiService = ApiClient.retrofit.create(ApiService::class.java)
        apiService.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    response.body()?.let { posts ->
                        postAdapter = PostAdapter(posts)
                        recyclerView.adapter = postAdapter
                    }
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e("API", t.toString())
            }

        })
        getOperations()
    }

    private fun getOperations() {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val contentType = "application/json".toMediaType()
        val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

        val retrofit = Retrofit.Builder().client(client)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .baseUrl(BASE_URl).build()

        val service = retrofit.create(OperationService::class.java)
        service.getOperations("operations").enqueue(
            object : Callback<Operations> {
                override fun onResponse(call: Call<Operations>, response: Response<Operations>) {
                    if (response.isSuccessful) {
                        val operations = response.body()
                        Log.i(TAG, operations.toString())
                    }
                }

                override fun onFailure(call: Call<Operations>, t: Throwable) {
                    Log.e(TAG, t.toString())
                }

            })
    }

    private companion object {
        const val BASE_URl = "https://raw.githubusercontent.com/InternetEducation/"
        const val TAG = "MainActivity"
    }
}