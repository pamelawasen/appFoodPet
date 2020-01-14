package com.example.appfoodpet

import com.google.gson.GsonBuilder
import java.io.Serializable

class EnderecoList:Serializable {
    var idendereco:Int =0
    var logradouro = ""
    var numero = ""
    var complemento = ""
    var bairro = ""
    var nmcep = ""

    override fun toString(): String {
        return "logradouro(logradouro=´${logradouro}´  )"
    }
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)

    }
}