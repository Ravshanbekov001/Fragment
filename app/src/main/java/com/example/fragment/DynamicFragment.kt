package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.fragment.fragments.Dynamic
import kotlinx.android.synthetic.main.activity_dynamic_fragment.*
import kotlinx.android.synthetic.main.fragment_dynamic.*

class DynamicFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_fragment)

        supportActionBar?.title = "Dynamic fragment"
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_new_24)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val dynamicFragment = Dynamic()
        val fragmentManager = supportFragmentManager

        add.setOnClickListener {
            fragmentManager.beginTransaction()
                .add(R.id.liner1, dynamicFragment)
                .commit()

            val animation = AnimationUtils.loadAnimation(this, R.anim.fragment_anim1)
            liner1.startAnimation(animation)
        }


        remove.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.fragment_anim2)
            liner1.startAnimation(animation)

            fragmentManager.beginTransaction()
                .remove(dynamicFragment)
                .commit()
        }


        hide.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.fragment_anim3)
            liner1.startAnimation(animation)

            fragmentManager.beginTransaction()
                .hide(dynamicFragment)
                .commit()
        }


        show.setOnClickListener {
            fragmentManager.beginTransaction()
                .show(dynamicFragment)
                .commit()

            val animation = AnimationUtils.loadAnimation(this, R.anim.fragment_anim4)
            liner1.startAnimation(animation)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}