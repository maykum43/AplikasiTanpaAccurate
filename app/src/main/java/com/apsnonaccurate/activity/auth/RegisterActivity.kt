package com.apsnonaccurate.activity.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.apsnonaccurate.MainActivity
import com.apsnonaccurate.R
import com.apsnonaccurate.app.ApiConfig
import com.apsnonaccurate.helper.SharedPref
import com.apsnonaccurate.model.ResponModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    lateinit var s: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        s = SharedPref(this)

        val btnDaftar = findViewById<Button>(R.id.btn_daftar)

        btnDaftar.setOnClickListener{
            register()
        }
    }

    fun register(){
        val edt_nama = findViewById<EditText>(R.id.tv_namaUser)
        val edt_email = findViewById<EditText>(R.id.tv_email)
        val edt_alamat = findViewById<EditText>(R.id.tv_alamat)
        val edt_notlp = findViewById<EditText>(R.id.tv_notlp)
        val edt_norek = findViewById<EditText>(R.id.tv_norek)
        val edt_nama_bank = findViewById<EditText>(R.id.tv_nama_bank)
        val edt_atas_nama= findViewById<EditText>(R.id.tv_atas_nama)
        val edt_pass = findViewById<EditText>(R.id.tv_password)
        val edt_copass = findViewById<EditText>(R.id.tv_co_password)

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
        } else if(edt_norek.text.isEmpty()){
            edt_notlp.error = "Kolom No. Rekening tidak boleh kosong!"
            edt_notlp.requestFocus()
            return
        } else if(edt_nama_bank.text.isEmpty()){
            edt_notlp.error = "Kolom Nama Bank tidak boleh kosong!"
            edt_notlp.requestFocus()
            return
        } else if(edt_atas_nama.text.isEmpty()){
            edt_notlp.error = "Kolom Nama Pemilik Rekening tidak boleh kosong!"
            edt_notlp.requestFocus()
            return
        } else if(edt_pass.text.isEmpty()){
            edt_pass.error = "Kolom password tidak boleh kosong!"
            edt_pass.requestFocus()
            return
        } else if (edt_pass.length() < 6) {
            edt_pass.error = "Password kurang dari 6 karakter"
            edt_pass.requestFocus()
//        }else if (edt_pass.equals(edt_copass)) {
//            Toast.makeText(this, "Password Sesuai", Toast.LENGTH_SHORT).show();
//            TextInputLayout cekLayout = findViewById(R.id.field_cek);
//            cekLayout.setEndIconMode(TextInputLayout.END_ICON_CUSTOM);
//            cekLayout.setEndIconDrawable(R.drawable.ic_baseline_check_circle_24);
//        }else if(edt_copass.text.isEmpty()){
//            edt_copass.error = "Kolom confirmasi password tidak boleh kosong!"
//            edt_copass.requestFocus()
//            return
//        } else if (edt_copass.text != edt_pass.text){
//            edt_copass.error = "Kolom confirmasi password tidak sama dengan password"
//            edt_copass.requestFocus()
//            return
        }else{
            val pb = findViewById<ProgressBar>(R.id.pb_regist)

            pb.visibility = View.VISIBLE

            ApiConfig.instanceRetrofit.register(
                edt_nama.text.toString(),
                edt_email.text.toString(),
                edt_alamat.text.toString(),
                edt_notlp.text.toString(),
                edt_norek.text.toString(),
                edt_nama_bank.text.toString(),
                edt_atas_nama.text.toString(),
                edt_pass.text.toString(),).enqueue(object :
                Callback<ResponModel> {

                override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                    //Response Gagal
                    pb.visibility = View.GONE
                    Toast.makeText(this@RegisterActivity, "Error: "+t.message, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<ResponModel>, onResponse: Response<ResponModel>) {
                    pb.visibility = View.GONE

                    val respon = onResponse.body()!!

                    if(respon.success == 1){
                        //berhasil
                        s.setStatusLogin(true)
                        val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        finish()
                        Toast.makeText(this@RegisterActivity, "Success: "+respon.message +" Selamat Datang "+respon.user.name, Toast.LENGTH_LONG).show()
                    }else {
                        //gagal
                        Toast.makeText(this@RegisterActivity, "Error: "+respon.message, Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }
}