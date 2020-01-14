package com.example.appfoodpet

import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appfoodpet.Services.CadastroService
import kotlinx.android.synthetic.main.activity_exibicao.*
import kotlinx.coroutines.flow.callbackFlow
import okhttp3.OkHttpClient


class ExibicaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibicao)



        btnCadastrar.setOnClickListener {

            val cadastro = CadastroClientes()
            cadastro.Nome=editNome.text.toString()
            cadastro.Cpf=editCPF.text.toString()
            cadastro.Email=editEmail.text.toString()
            cadastro.Telefone = (R.id.editPhone)
            cadastro.Senha=editConfirmeSenha.text.toString()
            cadastrar(cadastro)
        }
    }
    @TargetApi(Build.VERSION_CODES.O)
    private fun cadastrar(cad:CadastroClientes) {
        if (editNome.text.toString() == "" ||editCPF.text.toString() == "" || editEmail.text.toString() == "") {
            Toast.makeText(this, "Necessário preencher todos os campos", Toast.LENGTH_LONG)
                .show()
        }else if
        (editSenha.text.toString() != editConfirmeSenha.text.toString()) {
            Toast.makeText(this, "As senhas não conferem", Toast.LENGTH_LONG).show()
            editConfirmeSenha?.focusable
        } else {
            Thread {
                CadastroService.postCadastro(cad)
                runOnUiThread {

                    Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_LONG).show()
                    var proxima = Intent(this, LoginActivity::class.java)
                    startActivity(proxima)
                    finish()
                }
            }.start()
        }
    }

}


