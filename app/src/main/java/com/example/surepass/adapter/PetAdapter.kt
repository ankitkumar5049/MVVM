package com.example.surepass.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.surepass.R
import com.example.surepass.data.AdoptAPetEntry

class PetAdapter(context: Context, private val petList: List<AdoptAPetEntry>) :
    ArrayAdapter<AdoptAPetEntry>(context, 0, petList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.list_item_pet, parent, false)

        val pet = petList[position]

        val textViewName = itemView.findViewById<TextView>(R.id.textViewName)
        textViewName.text = pet.API

        return itemView
    }
}
