package com.example.tasty.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tasty.R
import com.example.tasty.model.remote.searchResponse.ResultSearchModel
import com.example.tasty.repositories.Repo
import com.example.tasty.view.adapters.SeachAdapter
import com.example.tasty.view.interfaces.OnSearchCardClicked
import com.example.tasty.viewmodel.MainViewModel
import com.example.tasty.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity(), OnSearchCardClicked {

    lateinit var viewModel: MainViewModel
    private lateinit var adapter: SeachAdapter
    val repo = Repo()
    var list = emptyList<ResultSearchModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        viewModel = ViewModelProvider(this, ViewModelFactory(repo)).get(MainViewModel::class.java)
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                loadApi(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        loadApi("pasta")
    }

    fun loadApi(query: String){
        adapter = SeachAdapter(list, this)
        viewModel.getSearchDetail(query).observe(this) {
            list =
                it.data?.resultSearchModels!!
            recyclerViewSearch.adapter = adapter
            recyclerViewSearch.layoutManager = GridLayoutManager(this, 2)
        }
    }

    override fun onSearchCardClicked(resultSearchModel: ResultSearchModel) {
        Toast.makeText(this@SearchActivity, "clicked", Toast.LENGTH_SHORT).show()
    }
}
