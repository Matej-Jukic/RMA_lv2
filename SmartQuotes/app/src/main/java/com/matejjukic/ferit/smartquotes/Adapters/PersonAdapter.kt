package com.matejjukic.ferit.smartquotes.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matejjukic.ferit.smartquotes.Listeners.PersonInteractionListener
import com.matejjukic.ferit.smartquotes.Model.Person
import com.matejjukic.ferit.smartquotes.R

class PersonAdapter (
                     persons: List<Person>,
                     private val listener: PersonInteractionListener
)
    : RecyclerView.Adapter<PersonViewHolder>()
{
    private val persons: MutableList<Person> = mutableListOf()
    init {
        this.persons.clear()
        this.persons.addAll(persons)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.person_item, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = persons[position]
        holder.bind(person, listener)
    }

    override fun getItemCount()= persons.size

}