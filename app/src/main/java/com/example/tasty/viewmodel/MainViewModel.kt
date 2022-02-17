package com.example.tasty.viewmodel

import androidx.lifecycle.*
import com.example.tasty.model.remote.api.Resource
import com.example.tasty.repositories.Repo
import com.example.tasty.model.remote.api.response.ItemX
import com.example.tasty.model.remote.api.response.Result
import com.example.tasty.model.remote.searchResponse.SearchResponseModel
import kotlinx.coroutines.Dispatchers

class MainViewModel(val repo: Repo) : ViewModel() {

    fun getData(): LiveData<List<Result>> {
        return repo.getDataFromApi()
    }

    fun getDetail(int: Int): MutableLiveData<ItemX> {
        return repo.getDetailFromApi(int)
    }

    fun getSearchDetail(query: String): LiveData<Resource<SearchResponseModel>> {
        return liveData(Dispatchers.IO) {
            val data = repo.getSearchDataFromApi(query)
            emit(data)
        }
    }

}

class ViewModelFactory(repo: Repo) : ViewModelProvider.Factory {
    val repo = Repo()
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repo) as T
    }
}