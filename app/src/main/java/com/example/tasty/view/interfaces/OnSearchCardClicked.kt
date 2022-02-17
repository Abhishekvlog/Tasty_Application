package com.example.tasty.view.interfaces

import com.example.tasty.model.remote.searchResponse.ResultSearchModel

interface OnSearchCardClicked{
    fun onSearchCardClicked(resultSearchModel : ResultSearchModel)
}