package com.example.tasty.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tasty.R
import com.example.tasty.model.remote.api.response.ItemX
import com.example.tasty.view.interfaces.OnCardClicklistner
import kotlinx.android.synthetic.main.fooditem_view.view.*

class NestedDisFragAdapter(val foodlist:ArrayList<ItemX>,val onCardClicklistner: OnCardClicklistner): RecyclerView.Adapter<NestedDisFragAdapter.Foodholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Foodholder {
        return Foodholder(LayoutInflater.from(parent.context).inflate(R.layout.fooditem_view,parent,false))
    }

    override fun onBindViewHolder(holder: Foodholder, position: Int) {
        holder.setData(foodlist[position],onCardClicklistner)
    }

    override fun getItemCount(): Int {
        return foodlist.size
    }

    class Foodholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      fun setData(itemX: ItemX,onCardClicklistner: OnCardClicklistner){
          itemView.apply {
              if(itemX!=null && itemX.thumbnail_url!=null ){
                  Glide.with(food_image).load(itemX?.thumbnail_url).into(food_image)
                  food_name.text = itemX.name
              }
              foodCard.setOnClickListener {
                  onCardClicklistner.onCardclicked(itemX)
              }
          }

      }
    }
}