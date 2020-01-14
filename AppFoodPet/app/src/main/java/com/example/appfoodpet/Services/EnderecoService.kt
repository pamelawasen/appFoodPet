package com.example.appfoodpet.Services

import com.example.appfoodpet.CadastroClientes
import com.example.appfoodpet.EnderecoList
import com.example.appfoodpet.PedidoList
import com.example.appfoodpet.Rest.HttpHelper
import com.example.appfoodpet.Rest.Response
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object EnderecoService {
    val host = "http://192.168.15.10:44315"
    val TAG = "WS_HTTP_endereco"
  var idEnd:Int=PedidoList().idclienteendereco

     fun postCadastroEndereco(endereco:EnderecoList): EnderecoList {
        val json = HttpHelper.post("$host/api/endereco/addendereco/9",endereco.toJson())
        return Gson().fromJson(json,EnderecoList::class.java)
    }
    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}