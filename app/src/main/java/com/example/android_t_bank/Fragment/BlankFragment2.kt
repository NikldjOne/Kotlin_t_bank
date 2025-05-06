package com.example.android_t_bank.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.android_t_bank.databinding.Fragment2Binding


class BlankFragment2 : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = Fragment2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataModel.messageForFragment2.observe(activity as LifecycleOwner, {
            binding.tvMessage.text = it;
        })
        binding.bSendToFrag2.setOnClickListener {
            dataModel.messageForFragment1.value = "Hello from fragment 2"
        }
        binding.bSendToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Hello from fragment 2"
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}