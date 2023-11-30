package co.edu.unal.synmultas2.mainModule.model

import android.util.Log
import co.edu.unal.synmultas2.FineApplication
import co.edu.unal.synmultas2.common.entities.FineEntity
import co.edu.unal.synmultas2.common.utils.Constants
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainInteractor {
    fun getFinesByPlate(plate: String, callback: (MutableList<FineEntity>) -> Unit) {
        val url = Constants.FINES_API_URL + Constants.GET_FINE_BY_PLATE_ENDPOINT + plate
        val jsonArrayRequest = object : JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                val mutableListType = object : TypeToken<MutableList<FineEntity>>(){}.type
                val finesList = Gson()
                    .fromJson<MutableList<FineEntity>>(response.toString(),mutableListType)
                callback(finesList)
            },
            {
                it.printStackTrace()
            }
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["app-token"] = Constants.FINES_API_TOKEN
                return headers
            }
        }

        FineApplication.fineAPI.addToRequestQueue(jsonArrayRequest)
    }
}