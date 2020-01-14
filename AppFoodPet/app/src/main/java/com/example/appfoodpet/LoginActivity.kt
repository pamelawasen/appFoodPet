package com.example.appfoodpet

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appfoodpet.Services.LoginService
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnEntrar?.setOnClickListener {
            val login = LoginList()
            login.email = editEmailLogin.text.toString()
            login.senha = editSenhaLogin.text.toString()
            entrar(login)
        }
    }

    private fun entrar(log:LoginList) {
        if (log.email.isNullOrEmpty() && log.senha.isNullOrEmpty()){

            Toast.makeText(this,"Necessário preencher email e senha",Toast.LENGTH_LONG).show()
        }else {
            Thread {

                val saveClient = LoginService.postLogin(log)
                //LoginService.save(log)
                runOnUiThread {
                    val resu = saveClient.idcliente
                    enviar(resu)

                }
            }.start()
        }
    }
fun enviar(resu:Int){
    var intent = Intent(context,MainActivity::class.java)
    val parames = Bundle()
    parames.putInt("id",resu)
    intent.putExtras(parames)
    startActivity(intent)
    finish()
}

}
