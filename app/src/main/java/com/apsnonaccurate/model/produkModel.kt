package com.apsnonaccurate.model

import java.io.Serializable

class produkModel : Serializable {
    lateinit var ID_Produk : String
    lateinit var Model : String
    lateinit var Brand : String
    lateinit var Kategori : String
    var Foto : Int = 0
    lateinit var Detail : String
    lateinit var Stok : String
    lateinit var Harga : String
    lateinit var Discount : String

}