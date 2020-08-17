package com.dm.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_example.*

class ExampleFragment : Fragment() {

    var fragmentCallback: FragmentCallback? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentCallback) {
            fragmentCallback = context
        } else {
            throw IllegalStateException("Activity must implement FragmentCallback")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_example, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        textView.text = "fragment 1"

        actionBtn.text = fragmentCallback?.getActionButtonText()
        actionBtn.setOnClickListener {
            fragmentCallback?.buttonClick()
        }
    }
}

interface FragmentCallback {
    fun buttonClick()
    fun getActionButtonText(): String
}