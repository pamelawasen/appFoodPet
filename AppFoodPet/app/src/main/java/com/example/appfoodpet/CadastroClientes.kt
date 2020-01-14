package com.example.appfoodpet

import com.google.gson.GsonBuilder
import java.io.Serializable

class CadastroClientes:Serializable {
    var idcliente:Int = 0
    var Nome=""
    var Email=""
    var Cpf=""
    var Telefone:Int = 0
    var Senha=""


    override fun toString(): String {
        return "Prato(DsPrato=´${Nome}´  )"
    }
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}