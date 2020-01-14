@file:Suppress("UNREACHABLE_CODE")

package com.example.appfoodpet.Services

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.appfoodpet.CardapioList
import com.example.appfoodpet.DescricaoPedido
import com.example.appfoodpet.R
import com.example.appfoodpet.Rest.AndroidUtils
import com.example.appfoodpet.Rest.HttpHelper
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Response
import java.net.URL
import java.util.concurrent.TimeUnit


object CardapioService {
        val host = "http://192.168.15.10:44315"
        val TAG = "WS_HTTP_foodPet"


        fun getPratos (context: Context): List<CardapioList> {
                val url = "$host/api/cliente"
                val json = URL(url).readText()
                val cardapio: List<CardapioList> = parserJson(json)
                Log.d(TAG, json)

                return cardapio

    }
fun postPrato(desc: DescricaoPedido):Response{
    val json = HttpHelper.post("$host/api/pedido/preenche",desc.toJson())
    OkHttpClient.Builder().apply {
        readTimeout(40, TimeUnit.SECONDS)
        writeTimeout(40, TimeUnit.SECONDS)
        connectTimeout(40, TimeUnit.SECONDS)
    }

    return parserJson(json)
}

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson<T>(json, type)
    }
}