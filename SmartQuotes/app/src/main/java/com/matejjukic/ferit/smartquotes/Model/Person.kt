package com.matejjukic.ferit.smartquotes.Model

import java.io.Serializable

class Person(
             val name: String,
             val yearOfBirth: String,
             val yearOfDeath: String,
             val inspiringQuote: String,
             val photoPath: String
) : Serializable