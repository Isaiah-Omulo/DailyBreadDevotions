package com.nyandori.dailybreaddevotions

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.nyandori.dailybreaddevotions.databinding.DevotionItemRecyclerRowBinding

class DevotionAdapter (private val devotionList: List<DevotionModel>):
    RecyclerView.Adapter<DevotionAdapter.MyViewHolder>() {


    class MyViewHolder(private val binding: DevotionItemRecyclerRowBinding):
        RecyclerView.ViewHolder(binding.root)   {

            //Binding data
            fun bindData(devotion:DevotionModel){


                binding.apply {
                    binding.dateTextView.text = devotion.date
                    binding.textTitle.text = devotion.daily_bread_devotion.title



                    root.setOnClickListener{
                        DailyDevotionActivity.dailyDevotion = devotion.daily_bread_devotion
                           val intent = Intent(root.context, DailyDevotionActivity::class.java)
                        root.context.startActivity(intent)
                    }

                }



            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = DevotionItemRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
         return devotionList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(devotionList[position])
    }
}