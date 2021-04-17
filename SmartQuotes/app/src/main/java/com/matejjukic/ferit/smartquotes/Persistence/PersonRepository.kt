package com.matejjukic.ferit.smartquotes.Persistence

import com.matejjukic.ferit.smartquotes.Model.Person

object PersonRepository {
   private val persons: MutableList<Person>
    init {
        persons = retrievePersons()
    }
    private fun retrievePersons(): MutableList<Person>{
        return mutableListOf(
                Person(  "Dennis Ritchie", "1941", "2011", "UNIX is basically a simple OS but you have to be genius to understand simplicity", "https://upload.wikimedia.org/wikipedia/commons/2/23/Dennis_Ritchie_2011.jpg"),
                Person( "Bjarne Stroustrup", "1950", "", "There are only two kinds of languages: the ones people complain about and the ones nobody uses.", "https://upload.wikimedia.org/wikipedia/commons/d/da/BjarneStroustrup.jpg"),
                Person( "Steve Jobs", "1955", "2011", "I think the things you regret most in life are the things you didn’t do.", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Steve_Jobs_Headshot_2010-CROP.jpg/1280px-Steve_Jobs_Headshot_2010-CROP.jpg"),
                Person( "Kale Gospodar Vremena", "Nepoznato", "Još ne", "Mralee", "https://upload.wikimedia.org/wikipedia/commons/2/20/Boerenkool.jpg")
        )
    }
    fun remove(name: String) = persons.removeAll{ person -> person.name == name }
    fun get(name: String): Person? = persons.find { person -> person.name == name }
    fun getPersons(): List<Person> = persons
    fun add(person: Person) = persons.add(person)
    fun addPerson(person: Person, addedPerson: Person) {
        persons.add(persons.indexOf(person), addedPerson)
        persons.remove(person)
    }
}