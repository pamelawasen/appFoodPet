package com.example.appfoodpet

import com.example.appfoodpet.Services.LoginService
import com.google.gson.GsonBuilder
import java.io.Serializable

class PedidoList:Serializable {
    var idprato:Int =CardapioList().idprato
    var idcliente:Int = CadastroClientes().idcliente
    var idclienteendereco:Int = EnderecoList().idendereco
    var valor:Double= CardapioList().valor

    override fun toString(): String {
        return "Prato(idprato=´${idprato}´  )"
    }
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)

    }
}