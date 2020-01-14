package com.example.appfoodpet.Services

import com.example.appfoodpet.CadastroClientes
import com.example.appfoodpet.Rest.HttpHelper
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Response
import java.util.concurrent.TimeUnit

object CadastroService {
    val host = "http://192.168.15.10:44315"
    val TAG = "WS_HTTP_Cadastro"

    fun postCadastro(cliente:CadastroClientes):Response{
        val json = HttpHelper.post("$host/api/cadastro/insere",cliente.toJson())
       OkHttpClient.Builder().apply {
            readTimeout(40, TimeUnit.SECONDS)
            writeTimeout(40, TimeUnit.SECONDS)
            connectTimeout(40, TimeUnit.SECONDS)
            }
        return parserJson(json)
    }
    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}