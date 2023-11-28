package co.edu.unal.synmultas2.mainModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.edu.unal.synmultas2.common.entities.FineEntity
import co.edu.unal.synmultas2.mainModule.model.MainInteractor
import java.util.concurrent.LinkedBlockingQueue

class MainViewModel: ViewModel() {
    private var fineList: MutableList<FineEntity> = mutableListOf()
    private var interactor: MainInteractor = MainInteractor()

    private val fines: MutableLiveData<List<FineEntity>> by lazy {
        MutableLiveData<List<FineEntity>>().also {
            loadFines()
        }
    }

    fun getFines(): LiveData<List<FineEntity>>{
        return fines.also { loadFines() }
    }

    private fun loadFines(){
        interactor.getFinesByPlate {
            fines.value = it
            fineList = it
        }
    }
}