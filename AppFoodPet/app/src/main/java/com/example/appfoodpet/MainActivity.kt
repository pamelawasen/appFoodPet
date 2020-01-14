package com.example.appfoodpet

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appfoodpet.Services.CardapioService
import com.example.appfoodpet.ui.gallery.GalleryFragment
import kotlinx.android.synthetic.main.cardapio_adapter.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val contexto: Context get() = this
    private var cardapio = listOf<CardapioList>()
    var recycler: RecyclerView? = null

    private lateinit var appBarConfiguration: AppBarConfiguration
    private val context: Context get() = this
    var recebeid:Int = 0

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        recycler = recyclerCardapio
        recycler?.layoutManager = LinearLayoutManager(context)
        recycler?.itemAnimator = DefaultItemAnimator()
        recycler?.setHasFixedSize(true)

        // recebe dados da login
        val args = intent.extras
        val id = args.getInt("id")

        Toast.makeText(context,"recebi id " + id,Toast.LENGTH_LONG).show()
        recebeid = id


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
       appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }




    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    override fun onResume() {
        super.onResume()
// task para recuperar o cardapio
        taskPratos()

    }
    fun taskPratos() {
        Thread {

           this.cardapio = CardapioService.getPratos(contexto)
            runOnUiThread {

                recycler?.adapter = CardapioAdapter(this.cardapio) { onClickPrato(it) }
            }
        }.start()

    }


fun gerar(idprato:Int,prato:String,idcli:Int){
    val desc = DescricaoPedido()
    desc.dsprato = prato
    desc.idprato = idprato
    desc.idcliente = idcli
  Thread {
      CardapioService.postPrato(desc)

      runOnUiThread {

      }
  }.start()
}
    fun onClickPrato(cardapio: CardapioList) {
      //  manda(this.cardapio)
        gerar(cardapio.idprato,cardapio.dsPrato,recebeid)
        Toast.makeText(this,"clicou ${cardapio.dsPrato}",Toast.LENGTH_LONG).show()
        val intent = Intent(context,CadastroEnderecoActivity::class.java)
        val parames = Bundle()
        parames.putInt("idprato",cardapio.idprato)
        parames.putString("dsprato",cardapio.dsPrato)
        parames.putDouble("valor",cardapio.valor)
        intent.putExtras(parames)
        startActivity(intent)

    }


}
