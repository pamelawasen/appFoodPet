package com.example.appfoodpet


import com.google.gson.GsonBuilder
import java.io.Serializable

class CardapioList:Serializable {
    var idprato:Int=0
    var dsPrato=""
    var valor: Double =0.0
    var foto=R.drawable.comida1


    override fun toString(): String {
            return "Prato(DsPrato=´${dsPrato}´  )"
    }
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)

    }


}