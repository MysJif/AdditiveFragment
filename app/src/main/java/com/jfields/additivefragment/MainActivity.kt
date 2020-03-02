package com.jfields.additivefragment

import androidx.fragment.app.FragmentActivity
import android.os.Bundle

class MainActivity : FragmentActivity(), MathFragment.EditListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onButtonClick(addAmnt: Int) {

        val textFragment = supportFragmentManager.findFragmentById(R.id.text_fragment) as TextFragment

        textFragment.addText(addAmnt)
    }
}
