package com.example.android_t_bank

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_t_bank.CustomView.CustomVIewActivity
import com.example.android_t_bank.Fragment.MainActivityFragments
import com.example.android_t_bank.RecyclerView.RecyclerActivity
import com.example.android_t_bank.Retrofit.UI.RetrofitActivity
import com.example.android_t_bank.coroutines.CoroutinesActivity
import com.example.android_t_bank.databinding.ActivityMainBinding

interface Message {
    fun onChangeText(text: String)
}

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fragmentBtn.setOnClickListener {
            goScreen(MainActivityFragments::class.java)
        }

        binding.recyclerBtn.setOnClickListener {
            goScreen(RecyclerActivity::class.java)
        }
        binding.customViewBtn.setOnClickListener {
            goScreen(CustomVIewActivity::class.java)
        }
        binding.retrofitBtn.setOnClickListener {
            goScreen(RetrofitActivity::class.java)
        }
        binding.coroutinesBtn.setOnClickListener {
            goScreen(CoroutinesActivity::class.java)
        }
    }

    private fun <T> goScreen(cls: Class<T>) {
        val intent = Intent(this, cls)
        startActivity(intent)
    }

}