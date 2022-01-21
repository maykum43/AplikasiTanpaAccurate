package com.apsnonaccurate.activity

import android.content.Intent
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

        mainButton()
    }

    fun mainButton(){

        //Inisialisasi ID (Button)
        val btnLogin = findViewById<Button>(R.id.btn_ProsesLogin)
        val btnRegist = findViewById<TextView>(R.id.tv_regist)

        btnLogin.setOnClickListener {
            s.setStatusLogin(true)
        }

        btnRegist.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}