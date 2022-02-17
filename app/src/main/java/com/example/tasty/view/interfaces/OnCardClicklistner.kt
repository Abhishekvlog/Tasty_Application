package com.example.tasty.view.interfaces

import com.example.tasty.model.remote.api.response.ItemX

interface OnCardClicklistner {
    fun onCardclicked(itemX: ItemX)
}