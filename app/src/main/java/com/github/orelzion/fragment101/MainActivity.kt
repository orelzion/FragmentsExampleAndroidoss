package com.github.orelzion.fragment101

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    private val toggleFragmentsBtn: Button by lazy { findViewById(R.id.toggleFragments) }
    private var fragmentPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment(createFragment1(), addToBackStack = false)

        toggleFragmentsBtn.setOnClickListener {
            if (fragmentPosition == 0) {
                fragmentPosition = 1
                showFragment(createFragment2())
            } else {
                fragmentPosition = 0
                showFragment(createFragment1())
            }
        }
    }

    private fun showFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        supportFragmentManager.commit {
            replace(R.id.fragmentContainer, fragment)
            if (addToBackStack) {
                addToBackStack(null)
            }
        }
    }

    private fun createFragment1(): Fragment1 {
        return Fragment1.newInstance("Chips Harif")
    }

    private fun createFragment2(): Fragment2 {
        return Fragment2()
    }
}