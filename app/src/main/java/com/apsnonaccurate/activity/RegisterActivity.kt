package com.apsnonaccurate.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.apsnonaccurate.R
import com.apsnonaccurate.app.ApiConfig
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnDaftar = findViewById<Button>(R.id.btn_daftar)

        btnDaftar.setOnClickListener{
            register()
        }
    }

    fun register(){
        val edt_nama = findViewById<EditText>(R.id.tv_namaUser)
        val edt_alamat = findViewById<EditText>(R.id.tv_alamat)
        val edt_notlp = findViewById<EditText>(R.id.tv_notlp)
        val edt_email = findViewById<EditText>(R.id.tv_email)
        val edt_pass = findViewById<EditText>(R.id.tv_password)
        val edt_copass = findViewById<EditText>(R.id.tv_confirm_password)

        if(edt_nama.text.isEmpty()){
            edt_nama.error = "Kolom nama tidak boleh kosong!"
            edt_nama.requestFocus()
            return
        } else if(edt_email.text.isEmpty()){
            edt_email.error = "Kolom email tidak boleh kosong!"
            edt_email.requestFocus()
            return
        } else if(edt_alamat.text.isEmpty()){
            edt_alamat.error = "Kolom alamat tidak boleh kosong!"
            edt_alamat.requestFocus()
            return
        } else if(edt_notlp.text.isEmpty()){
            edt_notlp.error = "Kolom No. Telepon tidak boleh kosong!"
            edt_notlp.requestFocus()
            return
        } else if(edt_pass.text.isEmpty()){
            edt_pass.error = "Kolom password tidak boleh kosong!"
            edt_pass.requestFocus()
            return
        } else if(edt_copass.text.isEmpty()){
            edt_copass.error = "Kolom confirmasi password tidak boleh kosong!"
            edt_copass.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.register(edt_nama.text.toString(),edt_email.text.toString(),edt_pass.text.toString()).enqueue(object : Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                //Response Gagal
                Toast.makeText(this@RegisterActivity, "Error: "+t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                //Response Berhasil
                Toast.makeText(this@RegisterActivity, "Success", Toast.LENGTH_SHORT).show()
            }
        })
    }
}