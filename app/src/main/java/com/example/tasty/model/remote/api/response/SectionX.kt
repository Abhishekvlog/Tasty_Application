package com.example.tasty.model.remote.api.response

import java.io.Serializable

data class SectionX(
    val components: List<ComponentX>,
    val name: Any,
    val position: Int
):Serializable