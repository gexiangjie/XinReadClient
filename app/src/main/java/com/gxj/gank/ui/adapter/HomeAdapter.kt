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
        val binding:ItemHomeBinding = holder.binding
        binding.daily = dailyData
        binding.executePendingBindings()
        /*if (position == 0 || !dailyData.type.equals(mType)) {
            holder.tv_sort.visibility = View.VISIBLE
            holder.tv_sort.text = dailyData.type
        } else {
            holder.tv_sort.visibility = View.GONE
        }

        holder.tv_des.text = dailyData.desc
        holder.tv_author.text = dailyData.who
        holder.tv_date.text = DateUtil.UTCToStr(dailyData.createdAt!!)*/
//        mType = dailyData.type!!
    }

    fun setNewData(data: MutableList<DailyData>) {
        this.data = data
        notifyDataSetChanged()
    }


    class HomeViewHolder(binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding: ItemHomeBinding = binding
        /*val tv_sort = view.findViewById<TextView>(R.id.tv_sort)
        val tv_des = view.findViewById<TextView>(R.id.tv_des)
        val tv_author = view.findViewById<TextView>(R.id.tv_author)
        val tv_date = view.findViewById<TextView>(R.id.tv_date)*/

    }
}