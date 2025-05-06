package com.example.android_t_bank.Fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.android_t_bank.Message
import com.example.android_t_bank.databinding.Fragment1Binding


class BlankFragment : Fragment() {
    private var message: Message? = null
    lateinit var binding: Fragment1Binding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater)
//        binding.bSendToActivity.setOnClickListener {
//            message?.onChangeText("dawdasd")
//        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataModel.messageForFragment1.observe(activity as LifecycleOwner, {
            binding.textFragment1.text = it
        })
        binding.bSendToFrag1.setOnClickListener{
            dataModel.messageForFragment2.value = "hello from fragment 1"
        }
        binding.bSendToActivity.setOnClickListener{
            dataModel.messageForActivity.value  = "Hello activity from fragment 1"
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        message = context as? Message
    }

    override fun onDetach() {
        super.onDetach()
        message = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}