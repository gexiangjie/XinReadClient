package com.gxj.gank.ui.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gxj.gank.R
import com.gxj.gank.bean.DailyData
import com.gxj.gank.databinding.ItemHomeBinding

class HomeAdapter(private var data: MutableList<DailyData>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var mType = ""

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HomeViewHolder {
        val binding = DataBindingUtil.inflate<ItemHomeBinding>(
            LayoutInflater.from(p0.context),
            R.layout.item_home,
            p0,
            false
        )

        return HomeViewHolder(binding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val dailyData = data[position]
        val binding: ItemHomeBinding = holder.binding
        binding.daily = dailyData
        binding.type = mType
        binding.executePendingBindings()

        mType = dailyData.type!!
    }

    fun setNewData(data: MutableList<DailyData>) {
        this.data = data
        notifyDataSetChanged()
    }

    class HomeViewHolder(val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root)
}