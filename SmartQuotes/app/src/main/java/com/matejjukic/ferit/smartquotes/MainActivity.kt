package com.matejjukic.ferit.smartquotes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.matejjukic.ferit.smartquotes.Activities.AddPerson
import com.matejjukic.ferit.smartquotes.Adapters.PersonAdapter
import com.matejjukic.ferit.smartquotes.Model.Person
import com.matejjukic.ferit.smartquotes.Persistence.PersonRepository
import com.matejjukic.ferit.smartquotes.databinding.ActivityMainBinding
import com.matejjukic.ferit.smartquotes.Listeners.PersonInteractionListener



class MainActivity : AppCompatActivity(), PersonInteractionListener {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var personInteractionListener: PersonInteractionListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainBinding.fabAddPerson.setOnClickListener { onFabClick() }
        setContentView(mainBinding.root)
        setUpRecycler()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (
            requestCode == AddPerson.activityResultCode
            && resultCode == RESULT_OK
            && data != null
        ) {
            val person = data.getSerializableExtra("PERSON") as Person
            PersonRepository.add(person)
            setUpRecycler()
        }
    }

    private fun setUpRecycler() {

        mainBinding.rvPersons.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        personInteractionListener = this

        mainBinding.rvPersons.adapter = PersonAdapter(
           PersonRepository.getPersons(),
            personInteractionListener
        )
    }

    private fun onFabClick() {
        val editIntent = Intent(this, AddPerson::class.java)
        startActivityForResult(editIntent, AddPerson.activityResultCode)
    }

    override fun onSelectedPerson(person: Person) {
        Toast.makeText(this, person.inspiringQuote, Toast.LENGTH_SHORT).show()
    }

}