package com.rsanchez.appareaseys.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rsanchez.appareaseys.R
import com.rsanchez.appareaseys.model.Person
import com.rsanchez.appareaseys.utils.loadImgFromUrl
import kotlinx.android.synthetic.main.item_data.view.*


class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    lateinit var listPersonas : List<Person>
    lateinit var context: Context

    fun ListAdapter(context: Context,list :List<Person>){
        this.context = context
        this.listPersonas = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.item_data,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
       return listPersonas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = listPersonas.get(position)
            holder.bind(item,context)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre = view.nombrePerson
        var apellido = view.apellidoPerson
        var email = view.emailPerson
        var icon_img = view.imageIcon

        fun bind(persona:Person, context: Context){
            nombre.text = persona.first_name
            apellido.text = persona.last_name
            email.text = persona.email
            icon_img.loadImgFromUrl(persona.avatar)
        }
    }
}