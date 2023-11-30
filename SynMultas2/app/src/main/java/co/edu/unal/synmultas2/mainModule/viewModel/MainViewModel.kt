package co.edu.unal.synmultas2.mainModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.edu.unal.synmultas2.common.entities.FineEntity
import co.edu.unal.synmultas2.mainModule.model.MainInteractor
import java.util.concurrent.LinkedBlockingQueue

class MainViewModel: ViewModel() {
    private var mFineList: MutableList<FineEntity> = mutableListOf()
    private var mInteractor: MainInteractor = MainInteractor()
    private lateinit var mPlate:String

    private val fines: MutableLiveData<List<FineEntity>> by lazy {
        MutableLiveData<List<FineEntity>>().also {
            loadFines()
        }
    }

    fun setPlate(plate: String){
        this.mPlate=plate
    }

    fun getFines(): LiveData<List<FineEntity>>{
        return fines.also { loadFines() }
    }

    private fun loadFines(){
        mInteractor.getFinesByPlate(mPlate) {
            fines.value = it
            mFineList = it
        }
    }
}