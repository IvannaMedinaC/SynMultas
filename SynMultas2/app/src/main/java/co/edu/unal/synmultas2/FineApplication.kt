package co.edu.unal.synmultas2

import android.app.Application
import co.edu.unal.synmultas2.common.dataBase.FineAPI

class FineApplication: Application() {
    companion object{
        lateinit var fineAPI: FineAPI
    }

    override fun onCreate() {
        super.onCreate()
        fineAPI = FineAPI.getInstance(this)
    }
}