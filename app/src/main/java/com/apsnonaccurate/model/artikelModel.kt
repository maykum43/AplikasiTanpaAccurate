package com.apsnonaccurate.model

import java.io.Serializable

class artikelModel: Serializable {
    lateinit var id_artikel :String
    lateinit var jdl_artikel :String
    var foto : Int = 0
    lateinit var isi :String
    lateinit var source :String
    lateinit var tgl_post :String
}