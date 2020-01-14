package com.example.appfoodpet.Services

import com.example.appfoodpet.CadastroClientes
import com.example.appfoodpet.LoginList
import com.example.appfoodpet.R
import com.example.appfoodpet.Rest.HttpHelper
import com.example.appfoodpet.Services.ModelsApi.ClienteData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Response
import java.net.URL
import java.util.concurrent.TimeUnit

object LoginService {

    val host = "http://192.168.15.10:44315"
    val TAG = "WS_HTTP_Cadastro"

    fun postLogin(usuario:LoginList):LoginList{
        val json = HttpHelper.post("${CadastroService.host}/api/cadastro/login",usuario.toJson())
        OkHttpClient.Builder().apply {
            readTimeout(40, TimeUnit.SECONDS)
            writeTimeout(40, TimeUnit.SECONDS)
            connectTimeout(40, TimeUnit.SECONDS)
        }

        return Gson().fromJson(json, LoginList::class.java)
    }
    fun save(usuario: CadastroClientes): com.example.appfoodpet.Rest.Response {
        val json = HttpHelper.post("$host/api/cadastro/login", usuario.toJson())
        return parserJson(json)
    }
    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}