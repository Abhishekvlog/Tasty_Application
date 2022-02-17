package com.example.tasty.model.remote.api.response

import java.io.Serializable

data class TagX(
    val display_name: String,
    val id: Int,
    val name: String,
    val type: String
):Serializable