package com.matejjukic.ferit.smartquotes.Adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.matejjukic.ferit.smartquotes.Listeners.PersonInteractionListener
import com.matejjukic.ferit.smartquotes.Model.Person
import com.matejjukic.ferit.smartquotes.databinding.PersonItemBinding

class PersonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(person: Person, listener: PersonInteractionListener){

        val itemBinding = PersonItemBinding.bind(itemView)

        itemBinding.tvPersonName.text = person.name
        itemBinding.tvPersonYear.text = person.yearOfBirth + " - " + person.yearOfDeath
        Glide.with(itemView.context)
            .load(person.photoPath)
            .into(itemBinding.ivPersonPhoto)
        itemBinding.ivPersonPhoto.setOnClickListener { listener.onSelectedPerson(person) }
    }

}