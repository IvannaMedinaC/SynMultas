package co.edu.unal.synmultas.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.unal.synmultas.data.remote.FinesRepository
import co.edu.unal.synmultas.model.FineModel
import co.edu.unal.synmultas.ui.adapter.FineListener
import co.edu.unal.synmultas.ui.adapter.base.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

/*@HiltViewModel
class MyFinesViewModel @Inject constructor() : ViewModel(), FineListener {

    private val _finesList = MutableLiveData<List<FineModel>>()
    val finesList : LiveData<List<FineModel>>
        get() = _finesList

    val showToast = MutableLiveData<Event<FineModel>>()

    init {
        submitFineList()
    }

    private fun submitFineList(){
        viewModelScope.launch {
            fetchFines().collect{ list ->
                _finesList.value = list
            }
        }
    }

    private fun fetchFines() = flow<List<FineModel>> {
        emit(FinesRepository.finesList)
    }.flowOn(Dispatchers.IO)

    override fun onFineClicked(fine: FineModel) {
        showToast.value = Event(fine)
    }
}*/

class MyFinesViewModel: ViewModel(), FineListener {
    private val finesList = MutableLiveData<List<FineModel>>()
    val showToast = MutableLiveData<Event<FineModel>>()

    fun getFinesList(): MutableLiveData<List<FineModel>>{
        return this.finesList
    }

    override fun onFineClicked(fine: FineModel) {
        showToast.value = Event(fine)
    }
}