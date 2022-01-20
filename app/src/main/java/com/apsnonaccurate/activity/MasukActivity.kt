package com.apsnonaccurate.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.apsnonaccurate.R
import com.apsnonaccurate.helper.SharedPref

class MasukActivity : AppCompatActivity() {

    lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)

        s = SharedPref(this)

        //Inisialisasi ID (Button)
        val btnLogin = findViewById<TextView>(R.id.btn_ProsesLogin)

        btnLogin.setOnClickListener {
            s.setStatusLogin(true)
        }

    }
}