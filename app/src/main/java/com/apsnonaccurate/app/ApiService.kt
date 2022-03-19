package com.apsnonaccurate.app

import com.apsnonaccurate.model.ResponModel
import okhttp3.ResponseBody
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("name") name:String,
        @Field("email") email:String,
        @Field("alamat") nomortlp:String,
        @Field("no_tlp") alamat:String,
        @Field("norek") norek:String,
        @Field("nama_bank") nama_bank:String,
        @Field("atas_nama") atas_nama:String,
        @Field("password") password:String
    ):Call<ResponModel>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email:String,
        @Field("password") password:String
    ) :Call<ResponModel>
}