package com.dm.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), FragmentCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = ExampleFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, fragment)
            .commit()


        navBtn.setOnClickListener {
            switchFragment()
        }
    }

    private fun switchFragment() {
        if(supportFragmentManager.findFragmentByTag("fragment2") == null) {

            val newFragment = ExampleFragment2()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, newFragment, "fragment2")
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this, "back button tap", Toast.LENGTH_SHORT).show()
    }

    override fun buttonClick() {
        switchFragment()
    }

    override fun getActionButtonText(): String = "switch fragment"
}