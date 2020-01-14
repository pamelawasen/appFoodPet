package com.example.appfoodpet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.lang.Exception

class PedidoAdapter (
    val finalizar : List<FinalizarPedidoList>,
    val onClick : (FinalizarPedidoList)->  Unit):
    RecyclerView.Adapter<PedidoAdapter.FinalizaViewHolder>(){
    class FinalizaViewHolder(view: View):RecyclerView.ViewHolder(view){
        val cardNome : TextView
        val cardQuantidade: TextView
        val cardNomeValor:TextView
        val cardEndEntrega:TextView
        val cardDataEntrega:TextView
        val cardNomeNumero :TextView
        val card:CardView


        init {
            cardNome = view.findViewById<TextView>(R.id.cardNomePedido)
            cardQuantidade = view.findViewById<TextView>(R.id.cardQuantidade)
            cardNomeValor = view.findViewById<TextView>(R.id.cardNomeValor)
            cardEndEntrega = view.findViewById<TextView>(R.id.cardEndEntrega)
            cardDataEntrega= view.findViewById<TextView>(R.id.cardDataEntrega)
            cardNomeNumero = view.findViewById(R.id.cardNomeNumero)
            card= view.findViewById<CardView>(R.id.card_pedido)
        }
    }
    override fun getItemCount() =this.finalizar.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinalizaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardapio_adapter, parent, false)
        val holder = FinalizaViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: FinalizaViewHolder, position: Int) {
        val context = holder.itemView.context
        val ped = finalizar[position]

        holder.cardNome.text = ped.dsprato
        holder.cardQuantidade.text = ped.quantidade.toString()
        holder.cardNomeValor.text = ped.valor.toString()
        holder.cardEndEntrega.text =  ped.logradouro
        holder.cardNomeNumero.text = ped.numero
        holder.cardDataEntrega.text = ped.dataEntrega



        holder.itemView.setOnClickListener {onClick(ped)}

    }
}
