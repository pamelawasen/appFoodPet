package com.example.appfoodpet

import com.google.gson.GsonBuilder
import java.io.Serializable

class FinalizarPedidoList:Serializable {
    var idpedido:Int = 0
    var idcliente:Int = 0
    var idEnderecoCliente:Int = 0
    var dsprato:String ="carmde"
    var logradouro:String ="ri"
    var numero:String ="328"
    var valor:Double = 0.0
    var quantidade:Int = 0
    var dataEntrega:String = "20/05/1996"
    override fun toString(): String {
        return "logradouro(logradouro=´${logradouro}´  )"
    }
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)

    }

}
