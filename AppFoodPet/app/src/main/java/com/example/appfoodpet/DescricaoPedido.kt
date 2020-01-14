package com.example.appfoodpet

import com.google.gson.GsonBuilder
import java.io.Serializable

class DescricaoPedido:Serializable {
    var dsprato :String =""
    var idprato:Int = 0
    var idcliente:Int =0

    override fun toString(): String {
        return "Prato(DsPrato=´${dsprato}´  )"
    }
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)

    }
}