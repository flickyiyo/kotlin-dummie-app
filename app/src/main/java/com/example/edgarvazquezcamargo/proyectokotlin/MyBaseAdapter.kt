package com.example.edgarvazquezcamargo.proyectokotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

/**
 * Created by edgarvazquezcamargo on 26/05/17.
 */

class MyBaseAdapter(context: Context):BaseAdapter(){

    internal var titulos = arrayOf("titulo 1","titulo 2", "titulo 3", "destiny ttk","destiny 2","cayde 6",
            "Zavala","Ikora")
    private val inflater :LayoutInflater

    init {
        this.inflater= LayoutInflater.from(context)
    }

    override fun getItem(position: Int): Any {
        return titulos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return titulos.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view : View?
        val vh : ListRowHolder
        if(convertView==null){
            view=this.inflater.inflate(R.layout.list_view_content,parent,false)
            vh = ListRowHolder(view)
            view.tag=vh
        }else{
            view = convertView
            vh = view.tag as ListRowHolder
        }
        vh.label.setText(titulos[position])
        return view

    }
    public class ListRowHolder(row:View?){
        public val label :TextView
        init{
            label = row?.findViewById(R.id.titulo) as TextView
        }
    }
}