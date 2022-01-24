package com.example.fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        btn1.setOnClickListener {
            startActivity(Intent(this, StaticFragment::class.java))
        }

        btn2.setOnClickListener {
            startActivity(Intent(this, DynamicFragment::class.java))
        }
    }
}