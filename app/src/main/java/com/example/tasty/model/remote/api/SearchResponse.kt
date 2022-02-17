package com.example.tasty.model.remote.api

data class SearchResponse(
	val results: List<ResultsItem?>? = null
)

data class ResultsItem(
	val searchValue: String? = null,
	val display: String? = null,
	val type: String? = null
)

