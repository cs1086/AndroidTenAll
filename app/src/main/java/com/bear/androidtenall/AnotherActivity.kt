package com.bear.androidtenall
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class AnotherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)
        val fragmentManager=supportFragmentManager
        val fragmentTrnsaction=fragmentManager.beginTransaction()
        fragmentTrnsaction.add(R.id.fragment,FragmentMain())
        fragmentTrnsaction.commit()
        fragmentTrnsaction.addToBackStack(null)
    }

    class MyAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        val data=(1..100).toList().toMutableList()

        companion object {
            const val TYPE_ITEM=0
            const val TYPE_HEADER=1
            const val TYPE_FOOTER=2
        }
        interface OnItemClickListener{
            fun onItemClick(index:Int)
        }
        private var clickListener:OnItemClickListener?=null

        fun setListener(clickListener:OnItemClickListener){
            this.clickListener=clickListener
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            Log.d("####","onCreateViewHolder")
            return when(viewType){
                TYPE_ITEM->MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_myholder,parent,false),clickListener)
                TYPE_HEADER->HeadHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_header,parent,false),clickListener)
                else->FooterHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_footer,parent,false),clickListener)
            }
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            if(holder is MyViewHolder){
                holder.setData(position)
            }
            if(holder is HeadHolder){
                holder.setData(position)
            }
            if(holder is FooterHolder){
                holder.setData(position)
            }
            Log.d("####","onBindViewHolder"+position)
        }

        override fun getItemCount()=data.size
        inner class MyViewHolder(itemView: View,private val listener:OnItemClickListener?):RecyclerView.ViewHolder(itemView){
            val thisText=itemView.findViewById<TextView>(R.id.thisText)
            fun setData(position:Int){
                thisText.text="我是第${position}列，數值為${data[position]}"
                itemView.setOnClickListener {
                    listener?.onItemClick(position)
                }
            }
        }
        inner class HeadHolder(itemView: View,private val listener:OnItemClickListener?):RecyclerView.ViewHolder(itemView){
            val thisText=itemView.findViewById<TextView>(R.id.thisText)
            fun setData(position:Int){
                thisText.text="我是第${position}列，數值為${data[position]}"
                itemView.setOnClickListener {
                    listener?.onItemClick(position)
                }
            }
        }
        inner class FooterHolder(itemView: View,private val listener:OnItemClickListener?):RecyclerView.ViewHolder(itemView){
            val thisText=itemView.findViewById<TextView>(R.id.thisText)
            fun setData(position:Int){
                thisText.text="我是第${position}列，數值為${data[position]}"
                itemView.setOnClickListener {
                    listener?.onItemClick(position)
                }
            }
        }
        override fun getItemViewType(position: Int): Int {
            return when(position){
                0-> TYPE_HEADER
                data.size-1-> TYPE_FOOTER
                else-> TYPE_ITEM
            }
        }
    }

}

