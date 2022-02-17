package com.example.tasty.model.remote.api.response

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity(tableName = "foodEntity")
data class Result(
    val category: String,
    @Embedded  //    to save non primitive type in database
    val item: Item,
    @Embedded
    val items: List<ItemX>,
    val min_items: Int,
    val name: String,
    val type: String
)
