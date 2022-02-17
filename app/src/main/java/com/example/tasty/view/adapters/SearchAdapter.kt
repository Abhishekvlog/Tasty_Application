package com.example.tasty.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tasty.R
import com.example.tasty.databinding.ItemLayoutBinding
import com.example.tasty.model.remote.searchResponse.ResultSearchModel
import com.example.tasty.view.interfaces.OnSearchCardClicked

class SeachAdapter(
    private val resultModelList: List<ResultSearchModel>,
    private val onSearchCardClicked: OnSearchCardClicked
) : RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemLayoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_layout, parent, false
            )
        return NewsViewHolder(itemLayoutBinding, onSearchCardClicked)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val articleModel = resultModelList[position]
        holder.onBind(articleModel)
    }

    override fun getItemCount(): Int {
        return resultModelList.size
    }
}

class NewsViewHolder(
    private val itemLayoutBinding: ItemLayoutBinding,
    private val onSearchCardClicked: OnSearchCardClicked
) :
    RecyclerView.ViewHolder(itemLayoutBinding.root) {

    fun onBind(resultSeachModel: ResultSearchModel) {
        itemLayoutBinding.onCardClicked = onSearchCardClicked
        Glide.with(itemLayoutBinding.ivCard).load(resultSeachModel.image)
            .into(itemLayoutBinding.ivCard)
    }

}