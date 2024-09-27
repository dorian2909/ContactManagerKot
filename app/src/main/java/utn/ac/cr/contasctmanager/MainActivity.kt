package utn.ac.cr.contasctmanager

import Util.util
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge

import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btnAddCont: Button = findViewById<Button>(R.id.addCont)
        btnAddCont.setOnClickListener(View.OnClickListener {view ->
            util.openActivity(this, ContactActivity::class.java)


            Toast.makeText(this, getString(R.string.Addcont).toString(), Toast.LENGTH_LONG).show()
            //Aqui mandamos un mensaje
        })
        val btnContactList: Button = findViewById<Button>(R.id.viewCont)
        btnContactList.setOnClickListener(View.OnClickListener {view ->
            util.openActivity(this, ContactListActivity::class.java)

            Toast.makeText(this, getString(R.string.List).toString(), Toast.LENGTH_LONG).show()

        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_Contact ->{
               util.openActivity(this, ContactActivity::class.java)//Le pasamos el parametro necesario que es una pantalla a abrirr
                return true
            }

            R.id.menu_ContactList ->{
                util.openActivity(this, ContactListActivity::class.java)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }




    }
   /* fun opeActivity(objClass: Class<*>){//Class<*> recibe un objeto de cualquier tipo
        val intentContAct = Intent(this, objClass)
        startActivity(intentContAct)//Aqui llamamos a una pantalla
    }*/
}