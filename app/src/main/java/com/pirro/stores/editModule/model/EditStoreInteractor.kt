package com.pirro.stores.editModule.model

import com.pirro.stores.StoreApplication
import com.pirro.stores.common.entities.StoreEntity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class EditStoreInteractor {

    fun saveStore(storeEntity: StoreEntity, callback: (Long)-> Unit){
        doAsync {
            val newId = StoreApplication.database.storeDao().addStore(storeEntity)
            StoreApplication.database.storeDao().delateStore(storeEntity)
            uiThread {
                callback(newId)
            }
        }
    }

    fun updateStore(storeEntity: StoreEntity, callback: (StoreEntity)-> Unit) {
        doAsync {
            StoreApplication.database.storeDao().updateStore(storeEntity)
            uiThread {
                callback(storeEntity)
            }
        }
    }
}