package com.example.learnkotlin.kotlin.model

open class Person(var name: String, var age: Int, var address: String) {
    fun getStringPerson(): String {
        return "Person(name='$name', age=$age, address='$address')"
    }
}