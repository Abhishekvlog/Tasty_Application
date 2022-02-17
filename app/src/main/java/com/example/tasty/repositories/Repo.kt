package com.example.tasty.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tasty.model.remote.Network
import com.example.tasty.model.remote.api.Resource
import com.example.tasty.model.remote.api.ResponseHandler
import com.example.tasty.model.remote.api.response.ItemX
import com.example.tasty.model.remote.api.response.Result
import com.example.tasty.model.remote.searchResponse.SearchResponseModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.Exception

class Repo() {

    var responseHandler: ResponseHandler = ResponseHandler()
    val liveData = MutableLiveData<List<Result>>()
    fun getDataFromApi(): LiveData<List<Result>> {       // liveData vs mutableLiveData!! why we have not used livedata here
        CoroutineScope(IO).launch {
            try {                                              // try is for scenerio if internet is not available it doesn't crash
                val list = Network.api.getData().results
                liveData.postValue(list)
            } catch (e: Exception) {
            }
        }
        return liveData
    }

    val liveData2 = MutableLiveData<ItemX>()
    fun getDetailFromApi(int: Int): MutableLiveData<ItemX> {
        CoroutineScope(IO).launch {
            liveData2.postValue(Network.api.getDetail(int))
        }
        return liveData2
    }


    suspend fun getSearchDataFromApi(query: String): Resource<SearchResponseModel> {
        return try {
            val response = Network.apiForSearch.getSearchview(
                "1b37e582323b49849577d6cb1ef567b9",
                query
            )
            responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}
