package com.example.appfoodpet

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_finalizar_pedido.*



class FinalizarPedidoActivity : AppCompatActivity() {

    private val finalizarPedido = listOf<FinalizarPedidoList>()
    private val context: Context get() = this
    var recycleFinalizar:RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finalizar_pedido)

    val pedido = FinalizarPedidoList()
        pedido

        recycleFinalizar = recyclerPedido
        recycleFinalizar?.layoutManager = LinearLayoutManager(context)
        recycleFinalizar?.itemAnimator = DefaultItemAnimator()
        recycleFinalizar?.setHasFixedSize(true)

    }

    override fun onResume() {
        super.onResume()
// task para recuperar o cardapio
        taskPedido()

    }
    fun taskPedido() {
        Thread {

            runOnUiThread {
                recycleFinalizar?.adapter = PedidoAdapter(this.finalizarPedido) {}
            }
        }.start()
    }
}
