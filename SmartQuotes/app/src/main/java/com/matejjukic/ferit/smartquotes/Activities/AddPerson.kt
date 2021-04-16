package com.matejjukic.ferit.smartquotes.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.matejjukic.ferit.smartquotes.Model.Person
import com.matejjukic.ferit.smartquotes.databinding.AddPersonBinding

class AddPerson : AppCompatActivity() {

    private lateinit var addPersonBinding: AddPersonBinding

       fun OnCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPersonBinding = AddPersonBinding.inflate(layoutInflater)
        setContentView(addPersonBinding.root)
        addPersonBinding.btnSave.setOnClickListener { savePerson() }
    }

    private fun savePerson() {
        val addedPerson = Person(
            addPersonBinding.etAddPersonName.text.toString(),
            addPersonBinding.etYearOfBirth.text.toString(),
            addPersonBinding.etYearOfDeath.text.toString(),
            addPersonBinding.etAddInspiringQuote.text.toString(),
            addPersonBinding.etEditPersonImageLink.text.toString()
        )
        val outputIntent = Intent()
        outputIntent.putExtra("person", addedPerson)
        setResult(RESULT_OK, outputIntent)
        finish()
    }

    companion object{
        const val activityResultCode: Int = 1;
    }


}