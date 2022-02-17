package com.example.tasty.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tasty.R
import com.example.tasty.model.remote.api.response.ItemX
import com.example.tasty.model.remote.api.response.Result
import com.example.tasty.view.interfaces.OnCardClicklistner
import kotlinx.android.synthetic.main.main_rv_item_layout.view.*

class DiscoverFragAdapter(
    val rvlist: ArrayList<Result>,
    val onCardClicklistner: OnCardClicklistner
) :
    RecyclerView.Adapter<DiscoverFragAdapter.MainRvViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRvViewHolder {
        return MainRvViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.main_rv_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainRvViewHolder, position: Int) {
        holder.setData(rvlist[position], onCardClicklistner)
    }

    override fun getItemCount(): Int = rvlist.size


    class MainRvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(result: Result, onCardClicklistner: OnCardClicklistner) {
            itemView.apply {
                tvHeading.text = result.name
                if (result.items != null)
                    nestedRecyclerView.apply {
                        adapter = NestedDisFragAdapter(
                            result.items as ArrayList<ItemX>,
                            onCardClicklistner
                        )
                        layoutManager = LinearLayoutManager(
                            itemView.context,
                            LinearLayoutManager.HORIZONTAL,
                            false
                        )
                    }
            }

        }

    }

}
