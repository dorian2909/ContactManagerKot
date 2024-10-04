package Model

import Entities.Contact
import android.content.res.Resources
import utn.ac.cr.contasctmanager.R

class ContactModel {
    companion object{
        private  var contactList = mutableListOf<Contact>()

        fun addContact(contact:Contact){
            contactList.add(contact)
        }
        fun getContacts() = contactList.toList()

        fun getContact(id: String):Contact{
            try {
                val result = contactList.filter { (it.id==id) }
                if (!result.any())
                    throw Exception(Resources.getSystem().getString(R.string.msgContactNotFound))
                return result[0]
            }catch (e:Exception){
                throw  e
            }
        }

        fun getContactName():List<String>{
            val name = mutableListOf<String>()
            contactList.forEach{i->name.add(i.fullName)}
            return name.toList()

        }
        //delete
        fun remoContact(id:String){
            try {

                contactList.remove(getContact(id))
            }catch (e:Exception){
                throw  e
            }
        }
    }
}