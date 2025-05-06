package com.example.android_t_bank.Fragment

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.android_t_bank.Message
import com.example.android_t_bank.R
import com.example.android_t_bank.databinding.ActivityMainFragmentsBinding

class MainActivityFragments : AppCompatActivity(), Message {
    lateinit var binding: ActivityMainFragmentsBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFrag(BlankFragment.newInstance(), R.id.place_holder)
        openFrag(BlankFragment2.newInstance(), R.id.place_holder2)
        dataModel.messageForActivity.observe(this, {
            binding.textView.text = it
        })
    }

    private fun openFrag(f: Fragment, idHolder: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
    override fun onChangeText(text: String) {
        binding.textView.text = text
    }
}