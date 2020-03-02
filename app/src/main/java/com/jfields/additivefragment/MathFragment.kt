package com.jfields.additivefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import android.content.Context
import kotlinx.android.synthetic.main.math_fragment.*
import java.lang.ClassCastException

class MathFragment : Fragment() {

    var activityCallback: MathFragment.EditListener? = null

    interface EditListener {
        fun onButtonClick(addAmnt: Int)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            activityCallback = context as EditListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context?.toString() + " must implement EditListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.math_fragment, container, false)

        val button: Button? = view?.findViewById(R.id.button1)


        button?.setOnClickListener { v: View -> buttonClicked(v) }

        return view
    }

    private fun buttonClicked(view: View) {
        activityCallback?.onButtonClick(editText1.text.toString().toInt())
    }
}