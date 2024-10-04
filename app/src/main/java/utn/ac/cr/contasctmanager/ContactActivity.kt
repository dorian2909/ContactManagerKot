package utn.ac.cr.contasctmanager

import Entities.Contact
import Model.ContactModel
import Util.util
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContactActivity : AppCompatActivity() {

    //el lateinint sirve para poder inicialisar la variable despues.
    private lateinit var txtId: EditText
    private lateinit var txtnom:EditText
    private lateinit var txtLastName:EditText
    private lateinit var txtPhone:EditText
    private lateinit var txtEmail:EditText
    private lateinit var txtAddress:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtId=findViewById<EditText>(R.id.txtContact_id)
        txtnom=findViewById<EditText>(R.id.txtNombre)
        txtLastName=findViewById<EditText>(R.id.txtLastName)

        txtPhone=findViewById<EditText>(R.id.txtPhone)
        txtEmail=findViewById<EditText>(R.id.txtEmail)
        txtAddress=findViewById<EditText>(R.id.txtAddress)


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.crud_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mnu_save -> {
                saveContact()
                return true
            }

            R.id.mnu_cancel -> {
                cleanScreen()
                return true
            }

            R.id.mnu_delete -> {
                deleteContact()
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun saveContact(){
    try {
        val contact = Contact()
        contact.id= txtId.toString()
        contact.name= txtnom.toString()
        contact.lastName= txtLastName.text.toString()
        contact.phone= txtPhone.text.toString().toInt()
        contact.email= txtEmail.toString()
        contact.address= txtAddress.toString()
        if(dataValidation((contact))){
            ContactModel.addContact(contact)
            cleanScreen()
            Toast.makeText(this, R.string.msgSatus200,Toast.LENGTH_SHORT).show()
        }

    }catch (e:Exception){
        Toast.makeText(this, R.string.msgFaltandatos, Toast.LENGTH_LONG).show()
    }
    }
    private fun dataValidation(contact:Contact):Boolean{
        return contact.id.isNotEmpty()
                && contact.name.isNotEmpty()
                && contact.fullName.isNotEmpty()
                && (contact.phone!=null &&contact.phone>0)
                && contact.email.isNotEmpty()
                && contact.address.isNotEmpty()

    }
    private fun cleanScreen(){
        txtId.setText("")
        txtnom.setText("")
        txtLastName.setText("")
        txtPhone.setText("")
        txtEmail.setText("")
        txtAddress.setText("")

    }
    private fun deleteContact(){

    }
}