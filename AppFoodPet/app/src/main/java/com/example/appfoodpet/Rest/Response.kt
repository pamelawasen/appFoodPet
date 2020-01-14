package com.example.appfoodpet.Rest

data class Response (val idcliente:Int, val nome:String) {
    // verificar se o chamada foi executada com sucesso
    fun isOK() = "OK".equals(nome, ignoreCase = true)
}