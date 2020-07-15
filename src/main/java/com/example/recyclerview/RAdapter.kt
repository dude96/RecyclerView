package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class RAdapter(var DataList: ArrayList<Data>) :
    RecyclerView.Adapter<RAdapter.ViewHolder>() {
    class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.TV1)
        private val text: TextView = itemView.findViewById(R.id.TV2)
        private val pic: ImageView = itemView.findViewById(R.id.ImageV)
        fun bind(data: Data) {
            title.text = data.title
            text.text = data.Text

            val requestOption = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOption)
                .load(data.Pic)
                .into(pic)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return DataList.size
    }

    fun submitList(datalist: Unit) {
        DataList = datalist as ArrayList<Data>
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            else -> {
                holder.bind(DataList[position])
            }
        }
    }
}


