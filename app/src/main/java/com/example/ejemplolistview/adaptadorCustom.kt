package com.example.ejemplolistview

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class adaptadorCustom(var context:Context, items: ArrayList<Fruta>):BaseAdapter() {
    var items:ArrayList<Fruta>? = null
    init {
        this.items = items
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder:ViewHolder? = null
        var vista:View? = convertView

        if (vista == null){
            vista = LayoutInflater.from(context).inflate(R.layout.template_frutas, null)
            holder = ViewHolder(vista)
            vista.tag = holder
        }
        else {
            holder = vista.tag as? ViewHolder
        }

        val item = getItem(position) as Fruta
        holder?.nombre?.text = item.nombre
        holder?.image?.setImageResource(item.imagen)

        return vista!!
    }

    override fun getItem(position: Int): Any {
        return items?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items?.count()!!
    }

    private class ViewHolder(vista:View) {
        var nombre:TextView? = null
        var image:ImageView? = null

        init {
            this.nombre = vista.findViewById(R.id.tvNombre)
            this.image = vista.findViewById(R.id.iImagen)
        }
    }
}