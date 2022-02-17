package com.example.tasty.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasty.R
import com.example.tasty.view.activities.SearchActivity
import com.example.tasty.view.adapters.DiscoverFragAdapter
import com.example.tasty.model.remote.api.SearchResponse
import com.example.tasty.model.remote.api.response.ItemX
import com.example.tasty.model.remote.api.response.Result
import com.example.tasty.repositories.Repo
import com.example.tasty.view.interfaces.OnCardClicklistner
import com.example.tasty.view.activities.FoodDetailActivity
import com.example.tasty.viewmodel.MainViewModel
import com.example.tasty.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_discover.*


class DiscoverFragment : Fragment(), OnCardClicklistner {
    lateinit var viewModel: MainViewModel
    lateinit var repo: Repo
    var list:MutableLiveData<SearchResponse> =MutableLiveData<SearchResponse>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //  dao = FoodDatabase.getDatabase(requireContext()).getDao()
        repo = Repo()
        viewModel = ViewModelProvider(this, ViewModelFactory(repo)).get(MainViewModel::class.java)

        viewModel.getData().observe(requireActivity(), Observer {
            val list =
                it as ArrayList<Result>              // we use here as to change type from list to arraylist
            setRecyclerView(list)
        })

        searchView.setOnClickListener {
            val intent = Intent(context, SearchActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setRecyclerView(list: ArrayList<Result>) {
        mainRecyclerview.adapter = DiscoverFragAdapter(list, this)
        mainRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onCardclicked(itemX: ItemX) {
        val intent = Intent(context, FoodDetailActivity::class.java)
        intent.putExtra(
            "foodName",
            itemX.id
        )       // we are just sending the id of the item whose data we want to show // through that we will call the data in the detail activity through api
        startActivity(intent)

    }

//    fun getSearchData()  {
//
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(p0: String?): Boolean {
//                if (p0 != null) {
//                  list =  viewModel.getSearchDetail(p0)
//                }
//                return false
//            }
//
//
//            override fun onQueryTextChange(p0: String?): Boolean {
//                if (p0 != null) {
//                    list = viewModel.getSearchDetail(p0)
//                }
//                return false
//            }
//
//        })
//
//    }

}