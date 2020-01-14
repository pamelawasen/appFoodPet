package com.example.appfoodpet

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appfoodpet.Services.CadastroService
import com.example.appfoodpet.Services.EnderecoService
import kotlinx.android.synthetic.main.activity_cadastro_endereco.*
import kotlinx.android.synthetic.main.cardapio_adapter.*

class CadastroEnderecoActivity : AppCompatActivity() {


    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_endereco)

        // recebe dados da main
        val args = intent.extras
        val id = args.getInt("idprato")
        val nomePrato = args.getString("dsprato")
        val valor = args.getDouble("valor")
        Toast.makeText(this,"recebi valor $id e $nomePrato",Toast.LENGTH_LONG).show()


        btnSalvar.setOnClickListener{

            val cadatroEndereco = EnderecoList()
            cadatroEndereco.logradouro = editLogradouro.text.toString()
            cadatroEndereco.numero = editnumero.text.toString()
            cadatroEndereco.complemento = editComplemento.text.toString()
            cadatroEndereco.bairro = editBairro.text.toString()
            cadatroEndereco.nmcep = editCep.text.toString()
            cadatroEnderecos(cadatroEndereco)
        }
    }


    private fun cadatroEnderecos(cad:EnderecoList){
        Thread {
           val ret = EnderecoService.postCadastroEndereco(cad)
            runOnUiThread {
                mandaFinalizar(ret)

            }
        }.start()
    }
fun mandaFinalizar(retorno:EnderecoList){
    var proxima = Intent(this, FinalizarPedidoActivity::class.java)
  /* val parames = Bundle()
    parames.putString("dsprato",id)
     parames.putString("idprato",idprato)
     parames.putString("qtdprato",qdt)
    intent.putExtras(parames)*/
    startActivity(proxima)
    finish()


}

}
