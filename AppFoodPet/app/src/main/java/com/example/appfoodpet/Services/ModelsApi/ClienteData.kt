package com.example.appfoodpet.Services.ModelsApi

import com.google.gson.annotations.SerializedName

data class ClienteData (
    @SerializedName("idcliente")
    val IdCliente: Int,
    val nome: String,
    val cpf: String,
    val email: String,
    val telefone: String,
    val senha: String,
    val dt_criado: String
)