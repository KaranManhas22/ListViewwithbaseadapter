package com.karan.listviewwithbaseadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class List_adapter(var List: ArrayList<String>): BaseAdapter()
{
    override fun getCount():Int {
        return List.size
    }

    override fun getItem(position: Int): Any {
        return List[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()


    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view =LayoutInflater.from(parent?.context).inflate(R.layout.activity_list_adapter,parent,false)
        var name=view?.findViewById<TextView>(R.id.name)
        name?.setText(List[position])
        return view
    }

}