package com.pirro.stores.editModule.viewModel

import android.text.BoringLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pirro.stores.common.entities.StoreEntity
import com.pirro.stores.editModule.model.EditStoreInteractor

class EditStoreViewModel:ViewModel() {
    private val storeSelect = MutableLiveData<StoreEntity>()
    private val showFab = MutableLiveData<Boolean>()
    private val result = MutableLiveData<Any>()

    private val interactor: EditStoreInteractor

    init {
        interactor = EditStoreInteractor()
    }

    fun setStoreSelected(storeEntity: StoreEntity){
        storeSelect.value = storeEntity
    }

    fun getStoreSelected(): LiveData<StoreEntity>{
        return storeSelect
    }

    fun setShowFab(isVisible: Boolean){
        showFab.value =isVisible
    }

    fun getShowFab(): LiveData<Boolean>{
        return showFab
    }

    fun setResult(value: Any){
        result.value = value
    }

    fun getResult(): LiveData<Any>{
        return result
    }

    fun saveStore(storeEntity: StoreEntity){
        interactor.saveStore(storeEntity, { newId ->
            result.value = newId
        })
    }

    fun updateStore(storeEntity: StoreEntity){
        interactor.updateStore(storeEntity, { storeUpdated ->
            result.value = storeUpdated
        })
    }
}