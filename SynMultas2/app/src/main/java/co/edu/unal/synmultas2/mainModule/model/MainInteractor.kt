package co.edu.unal.synmultas2.mainModule.model

import android.util.Log
import co.edu.unal.synmultas2.FineApplication
import co.edu.unal.synmultas2.common.entities.FineEntity
import co.edu.unal.synmultas2.common.utils.Constants
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest

class MainInteractor {
    fun getFinesByPlate(callback: (MutableList<FineEntity>) -> Unit){
        val url = Constants.FINES_API_URL+Constants.GET_FINE_BY_PLATE_ENDPOINT+"HOA508"
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null, { response ->
            Log.d("***response",response.toString())
        },{
            it.printStackTrace()
        })
        FineApplication.fineAPI.addToRequestQueue(jsonObjectRequest)
    }
}