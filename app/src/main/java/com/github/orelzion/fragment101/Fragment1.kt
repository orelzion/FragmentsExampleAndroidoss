package com.github.orelzion.fragment101

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class Fragment1: Fragment() {

    companion object {
        private const val TEXT_ARG = "text"

        fun newInstance(text: String? = null): Fragment1 {
            val fragment1 = Fragment1()
            fragment1.arguments = Bundle().apply {
                putString(TEXT_ARG, text)
            }
            return fragment1
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = view.findViewById<TextView>(R.id.tv1)

        requireArguments().getString(TEXT_ARG)?.let {
            textView.text = it
        }
    }
}