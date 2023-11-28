package co.edu.unal.synmultas2.common.dataBase

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class FineAPI constructor(context: Context) {
    companion object{
        @Volatile
        private var INSTANCE: FineAPI? = null

        fun getInstance(context: Context) = INSTANCE?: synchronized(this){
            INSTANCE ?: FineAPI(context).also { it }
        }
    }

    val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }

    fun <T> addToRequestQueue(req: Request<T>){
        requestQueue.add(req)
    }
}