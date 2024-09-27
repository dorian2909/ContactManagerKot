package utn.ac.cr.contasctmanager

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
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
            val intentContAct = Intent(this, ContactActivity::class.java)
            startActivity(intentContAct)//Aqui llamamos a una pantalla

            Toast.makeText(this, getString(R.string.Addcont).toString(), Toast.LENGTH_LONG).show()
            //Aqui mandamos un mensaje
        })
        val btnContactList: Button = findViewById<Button>(R.id.viewCont)
        btnContactList.setOnClickListener(View.OnClickListener {view ->
            val intentviewCont = Intent(this, ContactListActivity::class.java)
            startActivity(intentviewCont)

            Toast.makeText(this, getString(R.string.List).toString(), Toast.LENGTH_LONG).show()

        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }
}