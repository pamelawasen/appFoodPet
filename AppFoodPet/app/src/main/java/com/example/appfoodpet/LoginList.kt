package com.example.appfoodpet

import com.example.appfoodpet.Rest.Response
import com.google.gson.GsonBuilder
import java.io.Serializable

class LoginList:Serializable {
    var idcliente:Int = 0
    var email = ""
    var senha = ""

    override fun toString(): String {
        return "logradouro(email=´${email}´  )"
    }
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)

    }

}