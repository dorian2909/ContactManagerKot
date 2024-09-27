package Util

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity

class util {
    companion object {//clase estatica
        fun openActivity(context: Context, objClass: Class<*>){//funcion normal
            val inten= Intent(context, objClass)
            startActivity(context, inten, null)

        }

    }
}