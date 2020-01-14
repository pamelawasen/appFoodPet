package com.example.appfoodpet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.appfoodpet.Services.CardapioService
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import org.w3c.dom.Text
import java.lang.Exception

class CardapioAdapter (
    val cardapio : List<CardapioList>,
    val onClick : (CardapioList)->  Unit):
        RecyclerView.Adapter<CardapioAdapter.CardapioViewHolder>(){
    class CardapioViewHolder(view: View):RecyclerView.ViewHolder(view){
        val cardNome : TextView
        val cardImg: ImageView
        val cardProgress:ProgressBar
        val cardView:CardView

        init {
            cardNome = view.findViewById<TextView>(R.id.cardNome)
            cardImg = view.findViewById<ImageView>(R.id.cardImg)
            cardProgress = view.findViewById<ProgressBar>(R.id.cardProgress)
            cardView = view.findViewById<CardView>(R.id.card_cardapio)
        }
    }
    override fun getItemCount() =this.cardapio.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardapioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardapio_adapter, parent, false)
        val holder = CardapioViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: CardapioViewHolder, position: Int) {
        val context = holder.itemView.context
        val prato = cardapio[position]

        holder.cardNome.text = prato.dsPrato
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.get().load(prato.foto).fit().into(holder.cardImg,
            object: com.squareup.picasso.Callback{
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    holder.cardProgress.visibility = View.GONE
                }
            })
        holder.itemView.setOnClickListener {onClick(prato)}

    }
}
