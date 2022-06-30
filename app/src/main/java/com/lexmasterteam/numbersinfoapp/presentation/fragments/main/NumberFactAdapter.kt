package com.lexmasterteam.numbersinfoapp.presentation.fragments.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lexmasterteam.numbersinfoapp.databinding.CardViewRowBinding
import com.lexmasterteam.numbersinfoapp.domain.model.SavedNumberFact

class NumberFactAdapter: RecyclerView.Adapter<NumberFactAdapter.MyViewHolder>() {
    private var numberFactList = emptyList<SavedNumberFact>()
    inner class MyViewHolder(val binding: CardViewRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater = LayoutInflater.from(parent.context) // chyba po to się daje informacje o tym we fragmencie
        val binding = CardViewRowBinding.inflate(inflater,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = numberFactList[position]
        holder.binding.tvNumber.text = currentItem.number.toString()
        holder.binding.tvNumberInfo.text = currentItem.fact
    }

    override fun getItemCount(): Int {
        return numberFactList.size
    }
    fun setData(fact: List<SavedNumberFact>){
        this.numberFactList = fact
        notifyDataSetChanged()
    }
}