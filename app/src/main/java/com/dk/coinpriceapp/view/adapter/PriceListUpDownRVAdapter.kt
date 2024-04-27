package com.dk.coinpriceapp.view.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dk.coinpriceapp.R
import com.dk.coinpriceapp.dataModel.UpDownDataSet

class PriceListUpDownRVAdapter(val context : Context, val dataSet : List<UpDownDataSet>) : RecyclerView.Adapter<PriceListUpDownRVAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){

        val coinName = view.findViewById<TextView>(R.id.coinName)
        val coinPriceUpdown = view.findViewById<TextView>(R.id.coinPriceUpDown)
        val price = view.findViewById<TextView>(R.id.price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coin_price_change_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.coinName.text= dataSet[position].coinName

        if(dataSet[position].upDownPrice.contains("-")){
            holder.coinPriceUpdown.text = "하락"
            holder.coinPriceUpdown.setTextColor(Color.parseColor("#114fed"))
        } else{
            holder.coinPriceUpdown.text = "상승"
            holder.coinPriceUpdown.setTextColor(Color.parseColor("#ed2e11"))
        }

        holder.price.text = dataSet[position].upDownPrice.split(".")[0]
    }

}