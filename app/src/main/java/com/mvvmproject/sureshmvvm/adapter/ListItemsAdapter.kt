package com.mvvmproject.sureshmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonArray
import com.mvvmproject.sureshmvvm.R
import com.mvvmproject.sureshmvvm.databinding.ListItemBinding
import org.json.JSONObject

class ListItemsAdapter(val jsonArray: JsonArray):RecyclerView.Adapter<ListItemsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       var inflateView=DataBindingUtil.inflate<ListItemBinding>(
           LayoutInflater.from(parent.context)
           , R.layout.list_item, parent, false)
        return ViewHolder(inflateView)
    }

    override fun getItemCount()= jsonArray.size()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var jsonObject=JSONObject(jsonArray.get(position).toString())

        holder.itemBindig.title.text=""+jsonObject.getString("title")
    }

    class ViewHolder(itemVIew:ListItemBinding):RecyclerView.ViewHolder(itemVIew.root){
        val itemBindig=itemVIew
    }
}