package com.matejjukic.ferit.smartquotes.Persistence

import com.matejjukic.ferit.smartquotes.Model.Person

object PersonRepository {
   private val persons: MutableList<Person>
    init {
        persons = retrievePersons()
    }
    private fun retrievePersons(): MutableList<Person>{
        return mutableListOf(
                Person(  "Dennis Ritchie", "1941", "2011", "UNIX is basically a simple OS but you have to be genius to understand simplicity", "https://hr.wikipedia.org/wiki/Dennis_Ritchie#/media/Datoteka:Dennis_Ritchie_2011.jpg"),
                Person( "Bjarne Stroustrup", "1950", "", "There are only two kinds of languages: the ones people complain about and the ones nobody uses.", "https://bs.wikipedia.org/wiki/Bjarne_Stroustrup#/media/Datoteka:BjarneStroustrup.jpg"),
                Person( "Steve Jobs", "1955", "2011", "I think the things you regret most in life are the things you didn’t do.", "https://hr.wikipedia.org/wiki/Steve_Jobs#/media/Datoteka:Steve_Jobs_Headshot_2010-CROP.jpg"),
                Person( "Kale Gospodar Vremena", "Nepoznato", "Još ne", "Mralee", "https://www.facebook.com/1616925158571418/photos/a.1616929675237633/1616929681904299")
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